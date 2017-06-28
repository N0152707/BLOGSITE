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
        newBlog1.setBlogPublished("N");
        newBlog1.setBlogDatePublished(LocalDate.now());
        newBlog1.setBlogTitle("Test1CreateBlog");
        newBlog1.setBlogArticle("blog text added for number 1");
        newBlog1.setBlogDeleted("N");
        newBlog1.setUserBlogUserBlogId(1);
        newBlog1.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog1);
        Blog fromDb = blogdao.readBlog(newBlog1.getBlogId());
        Assert.assertEquals(fromDb, newBlog1);
    }

    /**
     * Test of readBlog method, of class BlogDao.
     */
    @Test
    public void testReadBlog() {
        Blog newBlog9 = new Blog();
        newBlog9.setBlogPublished("N");
        newBlog9.setBlogDatePublished(LocalDate.now());
        newBlog9.setBlogTitle("Test9CreateBlog");
        newBlog9.setBlogArticle("blog text added for number 9");
        newBlog9.setBlogDeleted("N");
        newBlog9.setUserBlogUserBlogId(1);
        newBlog9.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog9);
        Blog newBlog10 = new Blog();
        newBlog10.setBlogPublished("Y");
        newBlog10.setBlogDatePublished(LocalDate.now());
        newBlog10.setBlogTitle("Test1CreateBlog");
        newBlog10.setBlogArticle("blog text added for number 10");
        newBlog10.setBlogDeleted("N");
        newBlog10.setUserBlogUserBlogId(1);
        newBlog10.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog10);
        Blog fromDb = blogdao.readBlog(newBlog9.getBlogId());
        Assert.assertEquals(fromDb, newBlog9);
    }

    /**
     * Test of updateBlog method, of class BlogDao.
     */
    @Test
    public void testUpdateBlog() {
        Blog newBlog3 = new Blog();
        newBlog3.setBlogPublished("N");
        newBlog3.setBlogDatePublished(LocalDate.now());
        newBlog3.setBlogTitle("Test3CreateBlog");
        newBlog3.setBlogArticle("blog text added for number 3");
        newBlog3.setBlogDeleted("N");
        newBlog3.setUserBlogUserBlogId(1);
        newBlog3.setCategoryCategoryId(1);
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
        newBlog4.setBlogPublished("N");
        newBlog4.setBlogDatePublished(LocalDate.now());
        newBlog4.setBlogTitle("Test4CreateBlog");
        newBlog4.setBlogArticle("blog text added for number 4");
        newBlog4.setBlogDeleted("N");
        newBlog4.setUserBlogUserBlogId(1);
        newBlog4.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog4);
        Blog newBlog5 = new Blog();
        newBlog5.setBlogPublished("Y");
        newBlog5.setBlogDatePublished(LocalDate.now());
        newBlog5.setBlogTitle("Test5CreateBlog");
        newBlog5.setBlogArticle("blog text added for number 5");
        newBlog5.setBlogDeleted("N");
        newBlog5.setUserBlogUserBlogId(1);
        newBlog5.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog5);
        Blog newBlog6 = new Blog();
        newBlog6.setBlogPublished("N");
        newBlog6.setBlogDatePublished(LocalDate.now());
        newBlog6.setBlogTitle("Test6CreateBlog");
        newBlog6.setBlogArticle("blog text added for number 6");
        newBlog6.setBlogDeleted("Y");
        newBlog6.setUserBlogUserBlogId(1);
        newBlog6.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog6);
        Blog newBlog7 = new Blog();
        newBlog7.setBlogPublished("Y");
        newBlog7.setBlogDatePublished(LocalDate.now());
        newBlog7.setBlogTitle("Test7CreateBlog");
        newBlog7.setBlogArticle("blog text added for number 7");
        newBlog7.setBlogDeleted("Y");
        newBlog7.setUserBlogUserBlogId(1);
        newBlog7.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog7);
        Blog newBlog8 = new Blog();
        newBlog8.setBlogPublished("N");
        newBlog8.setBlogDatePublished(LocalDate.now());
        newBlog8.setBlogTitle("Test8CreateBlog");
        newBlog8.setBlogArticle("blog text added for number 8");
        newBlog8.setBlogDeleted("N");
        newBlog8.setUserBlogUserBlogId(1);
        newBlog8.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog8);
        List<Blog> blogList = blogdao.getLastFiveBlogs();
        assertEquals(blogList.size(), 5);

    }

//    @Test
//    public void testGetLastFiveBlogs() {
//        Blog newBlog4 = new Blog();
//        newBlog4.setBlogPublished("2017-03-01");
//        newBlog4.setBlogDatePublished(LocalDate.now());
//        newBlog4.setBlogTitle("Test4CreateBlog");
//        newBlog4.setBlogArticle("blog text added for number 4");
//        newBlog4.setBlogDeleted("No");
//        blogdao.createBlog(newBlog4);
//        Blog newBlog5 = new Blog();
//        newBlog5.setBlogPublished("2017-05-01");
//        newBlog5.setBlogDatePublished(LocalDate.now());
//        newBlog5.setBlogTitle("Test5CreateBlog");
//        newBlog5.setBlogArticle("blog text added for number 5");
//        newBlog5.setBlogDeleted("No");
//        blogdao.createBlog(newBlog5);
//        List<Blog> blogList = blogdao.getLastFiveBlogs();
//        assertEquals(blogList.size(), 5);
//
//    }
    /**
     * Test of getAllBlogsByCategory method, of class BlogDao.
     */
    @Test
    public void testGetAllBlogsByCategory() {
        Blog newBlog11 = new Blog();
        newBlog11.setBlogPublished("Y");
        newBlog11.setBlogDatePublished(LocalDate.now());
        newBlog11.setBlogTitle("Test11CreateBlog");
        newBlog11.setBlogArticle("blog text added for number 11");
        newBlog11.setBlogDeleted("N");
        newBlog11.setUserBlogUserBlogId(1);
        newBlog11.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog11);
        Blog newBlog12 = new Blog();
        newBlog12.setBlogPublished("N");
        newBlog12.setBlogDatePublished(LocalDate.now());
        newBlog12.setBlogTitle("Test12CreateBlog");
        newBlog12.setBlogArticle("blog text added for number 12");
        newBlog12.setBlogDeleted("Y");
        newBlog12.setUserBlogUserBlogId(1);
        newBlog12.setCategoryCategoryId(1);
        blogdao.createBlog(newBlog12);
    }

}
