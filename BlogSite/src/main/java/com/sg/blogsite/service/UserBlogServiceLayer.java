/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.UserBlog;

/**
 *
 * @author apprentice
 */
public interface UserBlogServiceLayer {

    public UserBlog createUserBlog(UserBlog userBlog);
//    public void removeUserBlog(int userBlogId);

    public void updateUserBlog(UserBlog userBlog);
//    public List<UserBlog> getAllUserBlogs();

    public UserBlog getUserBlogById(int userBlogId);

}
