/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.BlogStatic;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class BlogStaticDaoImpl implements BlogStaticDao {

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
                blogStatic.getBlogStaticTitle(),
                blogStatic.getBlogStaticArticle());
        int newId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        blogStatic.setBlogStaticId(newId);

        String fileName = blogStatic.getBlogStaticTitle();
        File f = new File("/home/apprentice/Documents/Bitbucket/blog-site-team-work/BLOGSITE/BlogSite/src/main/webapp/html/" + fileName + ".html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String staticContent = blogStatic.getBlogStaticArticle();
            bw.write(staticContent);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return blogStatic;
    }
}
