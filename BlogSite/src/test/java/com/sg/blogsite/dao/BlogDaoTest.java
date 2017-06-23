/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class BlogDaoTest {

    private BlogDao blogdao;

    public BlogDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createBlog method, of class BlogDao.
     */
    @Test
    public void testCreateBlog() {
        Blog newBlog1 = new Blog();
        newBlog1.setBlogPublished(Boolean.TRUE);
        newBlog1.setBlogDatePublished(LocalDate.MIN);
        newBlog1.setBlogTitle("TestCreateBlog");
        newBlog1.setBlogArticle("blog text added");
        blogdao.createBlog(newBlog1);
        Blog fromDb = blogdao.get
    }

    /**
     * Test of readBlog method, of class BlogDao.
     */
    @Test
    public void testReadBlog() {
    }

    /**
     * Test of updateBlog method, of class BlogDao.
     */
    @Test
    public void testUpdateBlog() {
    }

    /**
     * Test of getLastFiveBlogs method, of class BlogDao.
     */
    @Test
    public void testGetLastFiveBlogs() {
    }

    /**
     * Test of getAllBlogsByCategory method, of class BlogDao.
     */
    @Test
    public void testGetAllBlogsByCategory() {
    }

}
