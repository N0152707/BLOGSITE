/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

import java.util.Objects;

public class UserBlog {

    Integer userBlogId;
    String userBlogName;
    String userBlogPassword;
    String userBlogFirstName;
    String userBlogLastName;

    public Integer getUserBlogId() {
        return userBlogId;
    }

    public void setUserBlogId(Integer userBlogId) {
        this.userBlogId = userBlogId;
    }

    public String getUserBlogName() {
        return userBlogName;
    }

    public void setUserBlogName(String userBlogName) {
        this.userBlogName = userBlogName;
    }

    public String getUserBlogPassword() {
        return userBlogPassword;
    }

    public void setUserBlogPassword(String userBlogPassword) {
        this.userBlogPassword = userBlogPassword;
    }

    public String getUserBlogFirstName() {
        return userBlogFirstName;
    }

    public void setUserBlogFirstName(String userBlogFirstName) {
        this.userBlogFirstName = userBlogFirstName;
    }

    public String getUserBlogLastName() {
        return userBlogLastName;
    }

    public void setUserBlogLastName(String userBlogLastName) {
        this.userBlogLastName = userBlogLastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.userBlogId);
        hash = 43 * hash + Objects.hashCode(this.userBlogName);
        hash = 43 * hash + Objects.hashCode(this.userBlogPassword);
        hash = 43 * hash + Objects.hashCode(this.userBlogFirstName);
        hash = 43 * hash + Objects.hashCode(this.userBlogLastName);
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
        final UserBlog other = (UserBlog) obj;
        if (!Objects.equals(this.userBlogName, other.userBlogName)) {
            return false;
        }
        if (!Objects.equals(this.userBlogPassword, other.userBlogPassword)) {
            return false;
        }
        if (!Objects.equals(this.userBlogFirstName, other.userBlogFirstName)) {
            return false;
        }
        if (!Objects.equals(this.userBlogLastName, other.userBlogLastName)) {
            return false;
        }
        if (!Objects.equals(this.userBlogId, other.userBlogId)) {
            return false;
        }
        return true;
    }

}
