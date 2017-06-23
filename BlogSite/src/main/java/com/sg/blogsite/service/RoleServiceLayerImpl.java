/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.RoleDao;
import com.sg.blogsite.model.Role;

/**
 *
 * @author apprentice
 */
public class RoleServiceLayerImpl implements RoleServiceLayer {

    RoleDao roledao;

    public RoleServiceLayerImpl(RoleDao dao) {
        this.roledao = dao;
    }

    @Override
    public Role createRole(Role role) {
        roledao.createRole(role);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        roledao.updateRole(role);
    }

    @Override
    public Role getRoleById(int roleId) {
        return roledao.getRoleById(roleId);
    }

}
