/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.Blog;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface BlogServiceLayer {

    public Blog createBlog(Blog blog);

    public void deleteBlog(int blogId);

    public void updateBlog(Blog blog);

    public List<Blog> getAllBlogs();

    public Blog getLastFiveBlogs(int blogId);

}
