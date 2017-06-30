/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.BlogStaticDao;
import com.sg.blogsite.model.BlogStatic;


/**
 *
 * @author apprentice
 */
public class BlogStaticServiceLayerImpl implements BlogStaticServiceLayer{
     BlogStaticDao blogStaticDao;

    public BlogStaticServiceLayerImpl(BlogStaticDao dao) {
        this.blogStaticDao = dao;
    }

    @Override
    public BlogStatic createStaticBlog(BlogStatic blogStatic) {
        blogStaticDao.createStaticBlog(blogStatic);
        return blogStatic;
    }





   
}
