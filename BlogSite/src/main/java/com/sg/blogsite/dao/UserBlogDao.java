/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.UserBlog;
import java.util.List;

public interface UserBlogDao {

    public UserBlog createUserBlog(UserBlog userBlog);

    public void deleteUserBlog(int userBlogId);

    public void updateUserBlog(UserBlog userBlog);

    public UserBlog readUserBlog(int userBlogId);

    public List<UserBlog> getAllUserBlogs();

    public UserBlog getUserBlogById(int userBlogId);

}
