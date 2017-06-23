/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.UserBlogDao;
import com.sg.blogsite.model.UserBlog;

/**
 *
 * @author apprentice
 */
public class UserBlogServiceLayerImpl implements UserBlogServiceLayer {

    UserBlogDao userblogdao;

    public UserBlogServiceLayerImpl(UserBlogDao dao) {
        this.userblogdao = dao;
    }

    @Override
    public UserBlog getUserBlogById(int userBlogId) {
        return userblogdao.getUserBlogById(userBlogId);
    }

    @Override
    public UserBlog createUserBlog(UserBlog userBlog) {
        userblogdao.createUserBlog(userBlog);
        return userBlog;

    }

    @Override
    public void updateUserBlog(UserBlog userBlog) {
        userblogdao.updateUserBlog(userBlog);
    }

}
