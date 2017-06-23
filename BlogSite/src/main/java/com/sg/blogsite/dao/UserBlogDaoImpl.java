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
public class UserBlogDaoImpl {

    private static final String SQL_SELECT_USERBLOG
            = "select * from user_blog where user_blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserBlog getCategoryById(int userBlogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USERBLOG,
                    new UserBlogMapper(), userBlogId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just
            // want to return null in this case
            return null;
        }
    }

    private static final class UserBlogMapper implements RowMapper<UserBlog> {

        public UserBlog mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBlog userBlog = new UserBlog();
            userBlog.setUserBlogId(rs.getInt("user_blog_id"));
            userBlog.setUserBlogName(rs.getString("user_blog_name"));
            userBlog.setUserBlogPassword(rs.getString("user_blog_password"));
            return userBlog;
        }
    }
}
