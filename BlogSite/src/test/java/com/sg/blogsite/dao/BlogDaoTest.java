/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Blog;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        blogdao = ctx.getBean("blogDao", BlogDao.class);
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
        newBlog1.setBlogPublished("2017-09-01");
        newBlog1.setBlogDatePublished(LocalDate.now());
        newBlog1.setBlogTitle("Test1CreateBlog");
        newBlog1.setBlogArticle("blog text added for number 1");
        newBlog1.setBlogDeleted("No");
        blogdao.createBlog(newBlog1);
        Blog fromDb = blogdao.readBlog(newBlog1.getBlogId());
        Assert.assertEquals(fromDb, newBlog1);
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
        Blog newBlog3 = new Blog();
        newBlog3.setBlogPublished("2017-06-01");
        newBlog3.setBlogDatePublished(LocalDate.now());
        newBlog3.setBlogTitle("Test3CreateBlog");
        newBlog3.setBlogArticle("blog text added for number 3");
        newBlog3.setBlogDeleted("No");
        blogdao.createBlog(newBlog3);
        newBlog3.setBlogTitle("UpdatedBlogTitle");
        blogdao.updateBlog(newBlog3);
        Blog fromDb = blogdao.readBlog(newBlog3.getBlogId());
        assertEquals(fromDb, newBlog3);

    }

    /**
     * Test of getLastFiveBlogs method, of class BlogDao.
     */
    @Test
    public void testGetLastFiveBlogs() {
        Blog newBlog4 = new Blog();
        newBlog4.setBlogPublished("2017-03-01");
        newBlog4.setBlogDatePublished(LocalDate.now());
        newBlog4.setBlogTitle("Test4CreateBlog");
        newBlog4.setBlogArticle("blog text added for number 4");
        newBlog4.setBlogDeleted("No");
        blogdao.createBlog(newBlog4);
        Blog newBlog5 = new Blog();
        newBlog5.setBlogPublished("2017-05-01");
        newBlog5.setBlogDatePublished(LocalDate.now());
        newBlog5.setBlogTitle("Test5CreateBlog");
        newBlog5.setBlogArticle("blog text added for number 5");
        newBlog5.setBlogDeleted("No");
        blogdao.createBlog(newBlog5);
        List<Blog> blogList = blogdao.getLastFiveBlogs();
        assertEquals(blogList.size(), 5);

    }

    /**
     * Test of getAllBlogsByCategory method, of class BlogDao.
     */
    @Test
    public void testGetAllBlogsByCategory() {
    }

}
