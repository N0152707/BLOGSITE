/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.BlogDao;
import com.sg.blogsite.model.Blog;

/**
 *
 * @author apprentice
 */
public class BlogServiceLayerImpl implements BlogServiceLayer {

    BlogDao blogdao;

    public BlogServiceLayerImpl(BlogDao dao) {
        this.blogdao = dao;
    }

    @Override
    public Blog createBlog(Blog blog) {
        blogdao.createBlog(blog);
        return blog;
    }

    @Override
    public void updateBlog(Blog blog) {
        blogdao.updateBlog(blog);
    }

    @Override
    public void deleteBlog(int blogId) {
        blogdao.deleteBlog(blogId);
    }

    @Override
    public Object getAllBlogs() {
        return blogdao.getAllBlogs();
    }

    @Override
    public Blog getLastFiveBlogs(int blogId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
