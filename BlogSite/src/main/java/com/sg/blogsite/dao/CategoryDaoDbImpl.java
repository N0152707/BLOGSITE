/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class CategoryDaoDbImpl implements CategoryDao {

    private static final String SQL_INSERT_CATEGORY
            = "insert into category "
            + "(category_name "
            + "values (?)";
    private static final String SQL_SELECT_CATEGORY
            = "select * from category where category_id = ?";
    private static final String SQL_UPDATE_CATEGORY
            = "update category set "
            + "category_name = ? "
            + "where category_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category addCategory(Blog blog) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        category.setCategoryId(newId);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryName(),
                blog.getCategoryId());
    }

    @Override
    public Category getCategoryById(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY,
                    new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given id - we just
            // want to return null in this case
            return null;
        }
    }

    private static final class CategoryMapper implements RowMapper<Category> {

        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setCategoryId(rs.getInt("category_id"));
            category.setCategoryName(rs.getString("category_name"));
            return category;
        }
    }

}
