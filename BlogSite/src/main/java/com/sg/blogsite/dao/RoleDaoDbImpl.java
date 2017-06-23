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
    public Role addCategory(Role role) {
        jdbcTemplate.update(SQL_INSERT_ROLE,
                Role.getCategorRole());
        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
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
    public Role getRoleById(int roleId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ROLE,
                    new RoleMapper(), roleId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just
            // want to return null in this case
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
