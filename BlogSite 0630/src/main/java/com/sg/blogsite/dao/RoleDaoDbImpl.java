/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RoleDaoDbImpl implements RoleDao {

    private static final String SQL_SELECT_ROLE
            = "select * from role where role_id = ?";

    private static final String SQL_SELECT_ALL_ROLES
            = "select * from role";

    private static final String SQL_SELECT_ALL_ROLES_FOR_A_USERBLOG
            = "select role_has_user_blog.role_role_id, role_has_user_blog.user_blog_user_blog_id from role_has_user_blog where role_has_user_blog=role_has_user_blog.role_role_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role readRoleById(int roleId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ROLE,
                    new RoleMapper(), roleId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ROLES,
                new RoleMapper());
    }

    @Override
    public List<Role> getAllRolesInAUserBlog(int roleId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_ROLES_FOR_A_USERBLOG,
                new RoleMapper(), roleId);
    }

    private static final class RoleMapper implements RowMapper<Role> {

        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            return role;
        }
    }
}
