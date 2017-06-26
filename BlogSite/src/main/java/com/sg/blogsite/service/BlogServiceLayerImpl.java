package com.sg.blogsite.service;

import com.sg.blogsite.dao.BlogDao;
import com.sg.blogsite.model.Blog;
import java.util.List;

public class BlogServiceLayerImpl implements BlogServiceLayer {

    BlogDao blogDao;

    public BlogServiceLayerImpl(BlogDao dao) {
        this.blogDao = dao;
    }

    @Override
    public Blog createBlog(Blog blog) {
        blogDao.createBlog(blog);
        return blog;
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.updateBlog(blog);
    }

    @Override
    public Blog readBlog(int blogId) {
        return blogDao.readBlog(blogId);
    }

    @Override
    public List<Blog> getLastFiveBlogs() {
        return blogDao.getLastFiveBlogs();
    }

    @Override
    public List<Blog> getAllBlogsByCategory(int categoryId) {
        return blogDao.getAllBlogsByCategory(categoryId);
    }

}
