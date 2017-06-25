package com.sg.blogsite.service;

import com.sg.blogsite.dao.BlogDao;
import com.sg.blogsite.model.Blog;
import java.util.List;

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
    public Blog readBlog(int blogId) {
        return blogdao.readBlog(blogId);
    }

    @Override
    public List<Blog> getLastFiveBlogs() {
        return blogdao.getLastFiveBlogs();
    }

    @Override
    public List<Blog> getAllBlogsByCategory(int categoryId) {
        return blogdao.getAllBlogsByCategory(categoryId);
    }

}
