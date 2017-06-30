/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.BlogHasTag;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class BlogHasTagDaoDbImpl implements BlogHasTagDao {

    private static final String SQL_INSERT_BLOGHASTAG
            = "INSERT INTO blog_has_tag (blog_blog_id, tag_tag_id) VALUES (?, ?)";
    private static final String SQL_SELECT_BLOGHASTAG
            = "select * from blog_has_tag where blog_blog_id_id = ? and tag_tag_id= ?";
    private static final String SQL_SELECT_ALL_BLOGHASTAGS_IN_BLOG
            = "select blog_has_tag.blog_blog_id, blog_has_tag.tag_tag_id from blog_has_tag where bog_has_tag=blog_has_tag.blog_blog_id = ?";
    private static final String SQL_DELETE_BLOGHASTAG
            = "DELETE FROM blog_has_tag WHERE blog_blog_id=? and tag_tag_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createBlogHasTag(int blogId, int tagId) {
        jdbcTemplate.update(SQL_INSERT_BLOGHASTAG, blogId, tagId);
    }

    @Override
    public BlogHasTag readBlogHasTag(int blogId, int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOGHASTAG,
                    new BlogHasTagMapper(), blogId, tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteBlogHasTag(int blogId, int tagId) {
        jdbcTemplate.update(SQL_DELETE_BLOGHASTAG, blogId, tagId);
    }

    @Override
    public List<BlogHasTag> getAllBlogHasTagsInABlog(int blogId, int tagId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGHASTAGS_IN_BLOG,
                new BlogHasTagMapper(), blogId, tagId);
    }

    private static final class BlogHasTagMapper implements RowMapper<BlogHasTag> {

        public BlogHasTag mapRow(ResultSet rs, int rowNum) throws SQLException {
            BlogHasTag blogHasTag = new BlogHasTag();
            blogHasTag.setBlogBlogId(rs.getInt("blog_blog_id"));
            blogHasTag.setTagTagId(rs.getInt("tag_tag_id"));
            return blogHasTag;
        }
    }
}
