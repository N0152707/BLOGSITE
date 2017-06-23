/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class RoleDaoDbImpl implements RoleDao {

    private static final String SQL_INSERT_ROLE
            = "insert into role "
            + "(role_name "
            + "values (?)";
    private static final String SQL_SELECT_ROLE
            = "select * from role where role_id = ?";
    private static final String SQL_UPDATE_ROLE
            = "update role set "
            + "role_name = ? "
            + "where role_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Role createRole(Role role) {
        jdbcTemplate.update(SQL_INSERT_ROLE,
                role.getRoleName());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        role.setRoleId(newId);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        jdbcTemplate.update(SQL_UPDATE_ROLE,
                role.getRoleName(),
                role.getRoleId());
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

    private static final class RoleMapper implements RowMapper<Role> {

        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRoleName(rs.getString("role_name"));
            return role;
        }
    }

}
