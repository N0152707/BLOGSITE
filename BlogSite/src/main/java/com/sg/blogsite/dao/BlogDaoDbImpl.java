/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BlogDaoDbImpl implements BlogDao {

    private static final String SQL_INSERT_BLOG
            = "insert into blog "
            + "(blog_published, blog_deleted, blog_date_published, blog_title, "
            + "blog_article "
            + "values (?, ?, ?, ?)";
    private static final String SQL_SELECT_BLOG
            = "select * from blog where blog_id = ?";
    private static final String SQL_SELECT_ALL_BLOGS_BY_CATEGORY
            = "select * from blog where blog_category_id = ?";
    private static final String SQL_SELECT_LAST_FIVE_BLOGS
            = "select top(5) from blog order by blog_date_published DESC";
    private static final String SQL_UPDATE_BLOG
            = "update blog set "
            + "blog_published = ?, blog_deleted = ?, blog_date_published = ?, blog_title = ?, "
            + "blog_article = ? "
            + "where blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Blog createBlog(Blog blog) {
        jdbcTemplate.update(SQL_INSERT_BLOG,
                blog.getBlogPublished(),
                blog.getBlogDeleted(),
                blog.getBlogDatePublished().toString(),
                blog.getBlogTitle(),
                blog.getBlogArticle());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        blog.setBlogId(newId);
        return blog;
    }

    @Override
    public Blog readBlog(int blogId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOG,
                    new BlogMapper(), blogId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateBlog(Blog blog) {
        jdbcTemplate.update(SQL_UPDATE_BLOG,
                blog.getBlogPublished(),
                blog.getBlogDeleted(),
                blog.getBlogDatePublished().toString(),
                blog.getBlogTitle(),
                blog.getBlogArticle(),
                blog.getBlogId());
    }

    @Override
    public List<Blog> getLastFiveBlogs() {
        return jdbcTemplate.query(SQL_SELECT_LAST_FIVE_BLOGS,
                new BlogMapper());
    }

    @Override
    public List<Blog> getAllBlogsByCategory(int categoryId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGS_BY_CATEGORY,
                new BlogMapper());
    }

    private static final class BlogMapper implements RowMapper<Blog> {

        public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
            Blog blog = new Blog();
            blog.setBlogPublished(rs.getString("blogPublished"));
            blog.setBlogDeleted(rs.getString("blogDeleted"));
            blog.setBlogDatePublished((rs.getDate("blogDatePublished").toLocalDate()));
            blog.setBlogTitle(rs.getString("blogTitle"));
            blog.setBlogArticle(rs.getString("blogArticle"));
            blog.setBlogId(rs.getInt("blogId"));
            return blog;
        }
    }
}
