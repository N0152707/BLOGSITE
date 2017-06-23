/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CategoryDaoDbImpl implements CategoryDao {

    private static final String SQL_INSERT_CATEGORY
            = "insert into category "
            + "(category_name "
            + "values (?)";
    private static final String SQL_SELECT_CATEGORY
            = "select * from category where category_id = ?";
    private static final String SQL_SELECT_ALL_CATEGORIES
            = "select * from category";
    private static final String SQL_DELETE_CATEGORY
            = "SET SQL_SAFE_UPDATES=0; delete from category where category_id = ?";
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
    public Category createCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        category.setCategoryId(newId);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryName(),
                category.getCategoryId());
    }

    @Override
    public Category readCategory(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY,
                    new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void removeCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES,
                new CategoryMapper());
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
