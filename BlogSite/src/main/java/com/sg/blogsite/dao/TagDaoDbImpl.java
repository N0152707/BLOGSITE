/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

/**
 *
 * @author apprentice
 */
public class TagDaoDbImpl {

    private static final String SQL_INSERT_TAG
            = "insert into tag "
            + "(tag_name "
            + "values (?)";
    private static final String SQL_SELECT_TAG
            = "select * from tag where tag_id = ?";
    private static final String SQL_UPDATE_TAG
            = "update tag set "
            + "name_name = ? "
            + "where tag_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Tag addCategory(Tag tag) {
        jdbcTemplate.update(SQL_INSERT_TAG,
                tag.getTagName());
        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        tag.setTagId(newId);
        return tag;
    }

    @Override
    public void updateTag(Tag tag) {
        jdbcTemplate.update(SQL_UPDATE_TAG,
                tag.getTagName(),
                tag.getTagId());
    }

    @Override
    public Tag getCategoryById(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG,
                    new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just
            // want to return null in this case
            return null;
        }
    }

    private static final class TagMapper implements RowMapper<Tag> {

        public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tag tag = new Tag();
            tag.setTagId(rs.getInt("tag_id"));
            tag.setTagName(rs.getString("tag_name"));
            return tag;
        }
    }

}
