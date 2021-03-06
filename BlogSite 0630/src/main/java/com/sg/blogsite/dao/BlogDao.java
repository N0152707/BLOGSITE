/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import java.util.List;

public interface BlogDao {

    public Blog createBlog(Blog blog);

    public Blog readBlog(int blogId);

    public void updateBlog(Blog blog);

    public List<Blog> getLastFiveBlogs();

    public List<Blog> getAllBlogsByCategory(int categoryId);

    public List<Blog> getAllBlogsUnpublishedDeleted();

    public List<Blog> getAllBlogsByCategoryUnpublishedDeleted(int categoryId);

}
