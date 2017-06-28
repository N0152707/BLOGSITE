/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.UserBlog;
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
public class UserBlogDaoTest {

    private UserBlogDao userBlogDao;

    public UserBlogDaoTest() {
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
        userBlogDao = ctx.getBean("userBlogDao", UserBlogDao.class);
        /*        List<UserBlog> userBlogs = userBlogDao.getAllUserBlogs();
        for (UserBlog currentUserBlog : userBlogs) {
            userBlogDao.deleteUserBlog(currentUserBlog.getUserBlogId());
        }
         */    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createUserBlog method, of class UserBlogDao.
     */
    @Test
    public void testCreateUserBlog() {
        UserBlog newuseblog1 = new UserBlog();
        newuseblog1.setUserBlogName("TestBloggerName");
        newuseblog1.setUserBlogPassword("mypassword");
        newuseblog1.setUserBlogFirstName("Joe");
        newuseblog1.setUserBlogLastName("Smith");
        userBlogDao.createUserBlog(newuseblog1);
        UserBlog fromDb = userBlogDao.readUserBlog(newuseblog1.getUserBlogId());
        Assert.assertEquals(fromDb, newuseblog1);
        userBlogDao.deleteUserBlog(newuseblog1.getUserBlogId());
    }

    /**
     * Test of deleteUserBlog method, of class UserBlogDao.
     */
    @Test
    public void testDeleteUserBlog() {
        UserBlog newuseblog2 = new UserBlog();
        newuseblog2.setUserBlogName("TestBlogger123");
        newuseblog2.setUserBlogPassword("123password");
        newuseblog2.setUserBlogFirstName("Sam");
        newuseblog2.setUserBlogLastName("Dart");
        userBlogDao.createUserBlog(newuseblog2);
        UserBlog fromDb = userBlogDao.readUserBlog(newuseblog2.getUserBlogId());
        Assert.assertEquals(fromDb, newuseblog2);
        userBlogDao.deleteUserBlog(newuseblog2.getUserBlogId());
        Assert.assertNull(userBlogDao.readUserBlog(newuseblog2.getUserBlogId()));

    }

    /**
     * Test of updateUserBlog method, of class UserBlogDao.
     */
    @Test
    public void testUpdateUserBlog() {
        UserBlog newuseblog3 = new UserBlog();
        newuseblog3.setUserBlogName("TestBlogger44");
        newuseblog3.setUserBlogPassword("pass44");
        newuseblog3.setUserBlogFirstName("Dan");
        newuseblog3.setUserBlogLastName("Stanely");
        userBlogDao.createUserBlog(newuseblog3);
        newuseblog3.setUserBlogLastName("Forest");
        userBlogDao.updateUserBlog(newuseblog3);
        UserBlog fromDb = userBlogDao.readUserBlog(newuseblog3.getUserBlogId());
        Assert.assertEquals(fromDb, newuseblog3);
        userBlogDao.deleteUserBlog(newuseblog3.getUserBlogId());

    }

    /**
     * Test of getAllUserBlogs method, of class UserBlogDao.
     */
    @Test
    public void testGetAllUserBlogs() {
        UserBlog newuseblog4 = new UserBlog();
        newuseblog4.setUserBlogName("TestBlog123");
        newuseblog4.setUserBlogPassword("we12");
        newuseblog4.setUserBlogFirstName("Lou");
        newuseblog4.setUserBlogLastName("Wells");
        userBlogDao.createUserBlog(newuseblog4);
        UserBlog newuseblog5 = new UserBlog();
        newuseblog5.setUserBlogName("TestBlog600");
        newuseblog5.setUserBlogPassword("out6");
        newuseblog5.setUserBlogFirstName("Ray");
        newuseblog5.setUserBlogLastName("Capest");
        userBlogDao.createUserBlog(newuseblog5);
        List<UserBlog> UserBlogList = userBlogDao.getAllUserBlogs();
        assertEquals(UserBlogList.size(), 3);
        userBlogDao.deleteUserBlog(newuseblog4.getUserBlogId());
        userBlogDao.deleteUserBlog(newuseblog5.getUserBlogId());
    }

    /**
     * Test of getUserBlogById method, of class UserBlogDao.
     */
    @Test
    public void testGetUserBlogById() {
        UserBlog newuseblog6 = new UserBlog();
        newuseblog6.setUserBlogName("TestBlogTol");
        newuseblog6.setUserBlogPassword("34EET");
        newuseblog6.setUserBlogFirstName("Paul");
        newuseblog6.setUserBlogLastName("Sampson");
        userBlogDao.createUserBlog(newuseblog6);
        UserBlog fromDb = userBlogDao.readUserBlog(newuseblog6.getUserBlogId());
        Assert.assertEquals(fromDb, newuseblog6);
        userBlogDao.deleteUserBlog(newuseblog6.getUserBlogId());
    }

}
