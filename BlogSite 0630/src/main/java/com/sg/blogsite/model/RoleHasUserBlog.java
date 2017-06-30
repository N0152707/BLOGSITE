/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

/**
 *
 * @author apprentice
 */
public class RoleHasUserBlog {

    int userBlogUserBlogId;
    int roleRoleId;

    public int getUserBlogUserBlogId() {
        return userBlogUserBlogId;
    }

    public void setUserBlogUserBlogId(int userBlogUserBlogId) {
        this.userBlogUserBlogId = userBlogUserBlogId;
    }

    public int getRoleRoleId() {
        return roleRoleId;
    }

    public void setRoleRoleId(int roleRoleId) {
        this.roleRoleId = roleRoleId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.userBlogUserBlogId;
        hash = 79 * hash + this.roleRoleId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleHasUserBlog other = (RoleHasUserBlog) obj;
        if (this.userBlogUserBlogId != other.userBlogUserBlogId) {
            return false;
        }
        if (this.roleRoleId != other.roleRoleId) {
            return false;
        }
        return true;
    }

}
