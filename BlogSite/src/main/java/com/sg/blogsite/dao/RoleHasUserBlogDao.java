/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.RoleHasUserBlog;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface RoleHasUserBlogDao {

    public List<RoleHasUserBlog> getAllRoleHasUserBlogsForAUserBlog(int userBlogId, int roleId);

}
