/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class BlogDaoDbImpl implements BlogDao {

    private static final String SQL_INSERT_BLOG
            = "insert into blog "
            + "(blog_published, blog_date_published, blog_title, "
            + "blog_artical "
            + "values (?, ?, ?, ?)";
    private static final String SQL_SELECT_BLOG
            = "select * from blog where blog_id = ?";
    private static final String SQL_UPDATE_BLOG
            = "update blog set "
            + "blog_published = ?, blog_date_published = ?, blogTitle = ?, "
            + "blog_artical = ? "
            + "where blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Blog addBlog(Blog blog) {
        jdbcTemplate.update(SQL_INSERT_BLOG,
                blog.getBlogPublished(),
                blog.getBlogDatePublished().toString(),
                blog.getBlogTitle(),
                blog.getBlogArtical());
        // query the database for the id that was just assigned to the new
        // row in the database
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        // set the new id value on the contact object and return it
        blog.setBlogId(newId);
        return blog;
    }

    @Override
    public void updateBlog(Blog blog) {
        jdbcTemplate.update(SQL_UPDATE_BLOG,
                blog.getBlogPublished(),
                blog.getBlogDatePublished().toString(),
                blog.getBlogTitle(),
                blog.getBlogArtical(),
                blog.getBlogId());
    }

    @Override
    public Blog getBlogById(int blogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOG,
                    new BlogMapper(), blogId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just
            // want to return null in this case
            return null;
        }
    }

    private static final class BlogMapper implements RowMapper<Blog> {

        public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
            Blog blog = new Blog();
            blog.setBlogId(rs.getInt("blog_id"));
            blog.setPublished(rs.getBoolean("published"));
            blog.setBlogDatePublished(rs.getTimestamp("BlogDatePublished").toLocalDateTime());
            blog.setBlogTitle(rs.getString("glogTitle"));
            blog.setBlogArtical(rs.getString("blogArtical"));
            return blog;
        }
    }

}
