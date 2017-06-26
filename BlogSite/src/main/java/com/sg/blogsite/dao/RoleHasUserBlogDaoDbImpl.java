/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.RoleHasUserBlog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class RoleHasUserBlogDaoDbImpl implements RoleHasUserBlogDao {

    private static final String SQL_SELECT_ALL_ROLES_FOR_A_USERBLOG = "select * from role where user_blog_user_blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RoleHasUserBlog> getAllRoleHasUserBlogsForAUserBlog(int userBlogUserBlogId, int roleRoleId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_ROLES_FOR_A_USERBLOG,
                new RoleHasUserBlogMapper(), userBlogUserBlogId, roleRoleId);
    }

    private static final class RoleHasUserBlogMapper implements RowMapper<RoleHasUserBlog> {

        public RoleHasUserBlog mapRow(ResultSet rs, int rowNum) throws SQLException {
            RoleHasUserBlog roleHasUserBlog = new RoleHasUserBlog();
            roleHasUserBlog.setRoleRoleId(rs.getInt("role_role_id"));
            roleHasUserBlog.setUserBlogUserBlogId(rs.getInt("user_blog_user_blog_id"));
            return roleHasUserBlog;
        }
    }

}
