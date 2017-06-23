/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

import com.sg.blogsite.model.Role;

public interface RoleDao {

    public Role createRole(Role role);

    public void updateRole(Role role);

    //public List<Role> getAllRoles();
    public Role readRoleById(int roleId);

    // public void deleteRole(int roleId);
}
