/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Role;
import java.util.List;

public interface RoleDao {

    public List<Role> getAllRoles();

    public Role readRoleById(int roleId);

}
