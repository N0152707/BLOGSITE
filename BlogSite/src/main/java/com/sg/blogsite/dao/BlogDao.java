/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

/**
 *
 * @author apprentice
 */
public interface BlogDao {

    public Blog addBlog(Blog blog);

//    public void removeBlog(int blogId);
    public void updateBlog(Blog blog);

//    public List<Blog> getAllBlogs();
    public Blog getBlogById(int blogId);
}
