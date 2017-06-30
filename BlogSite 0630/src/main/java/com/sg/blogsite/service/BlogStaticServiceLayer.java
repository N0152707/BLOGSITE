/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.Blog;
import com.sg.blogsite.model.BlogStatic;

/**
 *
 * @author apprentice
 */
public interface BlogStaticServiceLayer {
    
    public BlogStatic createStaticBlog(BlogStatic blogStatic);
}
