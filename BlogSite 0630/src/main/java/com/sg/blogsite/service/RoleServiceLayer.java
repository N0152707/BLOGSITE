/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.model.Role;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface RoleServiceLayer {

    public List<Role> getAllRoles();

    public Role readRoleById(int roleId);

    public List<Role> getAllRolesInAUserBlog(int userBlogId);

}
