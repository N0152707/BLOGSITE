/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.dao;

/**
 *
 * @author apprentice
 */
public interface RoleDao {

    public Role addRole(Role role);

//    public void removeRole(int roleId);
    public void updateRole(Role role);

//    public List<Role> getAllRoles();
    public Role getRoleById(int roleId);

}
