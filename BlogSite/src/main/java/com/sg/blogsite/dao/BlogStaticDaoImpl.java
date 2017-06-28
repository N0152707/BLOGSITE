/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.BlogStatic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class BlogStaticDaoImpl implements BlogStaticDao  {

    
     private static final String SQL_INSERT_STATIC_BLOG
            = "insert into static_page "
            + "(blog_static_title, "
            + "blog_static_article) "
            + "values (?, ?)";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
      @Override
      @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public BlogStatic createStaticBlog(BlogStatic blogStatic) {
       jdbcTemplate.update(SQL_INSERT_STATIC_BLOG,
                blogStatic.getBlogStaticArticle(),
                blogStatic.getBlogStaticTitle());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        blogStatic.setBlogStaticId(newId);
        return blogStatic;
    }
 

}
    
    
    
    
  

   


  

