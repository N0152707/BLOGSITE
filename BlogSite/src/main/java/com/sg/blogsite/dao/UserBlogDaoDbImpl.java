/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.UserBlog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserBlogDaoDbImpl implements UserBlogDao {

    private static final String SQL_INSERT_USERBLOG
            = "insert into user_blog "
            + "(user_blog_name, user_blog_password, user_blog_first_name, user_blog_last_name) "
            + "values (?, ?, ?, ?)";
    private static final String SQL_SELECT_USERBLOG
            = "select * from user_blog where user_blog_id = ?";
    private static final String SQL_SELECT_USERBLOG_BY_ID
            = "select * from user_blog where user_blog_id = ?";
    private static final String SQL_SELECT_ALL_USERBLOGS
            = "select * from user_blog";
    private static final String SQL_DELETE_USERBLOG
            = " DELETE FROM user_blog WHERE user_blog_id = ?";
    private static final String SQL_UPDATE_USERBLOG
            = "UPDATE user_blog SET user_blog_name = ?, user_blog_password = ?, user_blog_first_name = ?, user_blog_last_name = ? WHERE user_blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserBlog createUserBlog(UserBlog userBlog) {
        jdbcTemplate.update(SQL_INSERT_USERBLOG,
                userBlog.getUserBlogName(),
                userBlog.getUserBlogPassword(),
                userBlog.getUserBlogFirstName(),
                userBlog.getUserBlogLastName());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        userBlog.setUserBlogId(newId);
        return userBlog;
    }

    @Override
    public void deleteUserBlog(int userBlogId) {
        jdbcTemplate.update(SQL_DELETE_USERBLOG, userBlogId);
    }

    @Override
    public void updateUserBlog(UserBlog userBlog) {
        jdbcTemplate.update(SQL_UPDATE_USERBLOG,
                userBlog.getUserBlogName(),
                userBlog.getUserBlogPassword(),
                userBlog.getUserBlogFirstName(),
                userBlog.getUserBlogLastName(),
                userBlog.getUserBlogId());
    }

    @Override
    public List<UserBlog> getAllUserBlogs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERBLOGS,
                new UserBlogMapper());
    }

    @Override
    public UserBlog getUserBlogById(int userBlogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USERBLOG_BY_ID,
                    new UserBlogMapper(), userBlogId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public UserBlog readUserBlog(int userBlogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USERBLOG,
                    new UserBlogMapper(), userBlogId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final class UserBlogMapper implements RowMapper<UserBlog> {

        public UserBlog mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBlog userBlog = new UserBlog();
            userBlog.setUserBlogId(rs.getInt("user_blog_id"));
            userBlog.setUserBlogName(rs.getString("user_blog_name"));
            userBlog.setUserBlogPassword(rs.getString("user_blog_password"));
            userBlog.setUserBlogFirstName(rs.getString("user_blog_first_name"));
            userBlog.setUserBlogLastName(rs.getString("user_blog_last_name"));
            return userBlog;
        }
    }
}
