/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TagDaoDbImpl implements TagDao {

    private static final String SQL_INSERT_TAG
            = "insert into tag "
            + "(tag_name) "
            + "values (?)";
    private static final String SQL_SELECT_TAG
            = "select * from tag where tag_id = ?";
    private static final String SQL_SELECT_ALL_TAGS
            = "select * from tag";
    //private static final String SQL_SELECT_ALL_TAGS_IN_BLOG
    //= "select * from tag";

    private static final String SQL_SELECT_ALL_TAGS_IN_BLOG
            = "select tag.tag_id, tag.tag_name from tag join blog_has_tag on tag_id = blog_id where tag.tag_id = ?";

    private static final String SQL_DELETE_TAG
            = "SET SQL_SAFE_UPDATES=0; delete from tag where tag_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Tag createTag(Tag tag) {
        jdbcTemplate.update(SQL_INSERT_TAG,
                tag.getTagName());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        tag.setTagId(newId);
        return tag;
    }

    @Override
    public Tag readTag(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG,
                    new TagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteTag(int tagId) {
        jdbcTemplate.update(SQL_DELETE_TAG, tagId);
    }

    @Override
    public List<Tag> getAllTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS,
                new TagMapper());
    }

    @Override
    public List<Tag> getAllTagsInABlog(int blogId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS_IN_BLOG,
                new TagMapper(), blogId);
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
