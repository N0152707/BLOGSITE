/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.service;

import com.sg.blogsite.dao.RoleDao;
import com.sg.blogsite.model.Role;
import java.util.List;

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
    public List<Role> getAllRoles() {
        return roledao.getAllRoles();
    }

    @Override
    public Role readRoleById(int roleId) {
        return roledao.readRoleById(roleId);
    }

}
