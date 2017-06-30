/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blogsite.model;

import java.time.LocalDate;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Blog {

    Integer blogId;
    String blogPublished;
    String blogDeleted;
    LocalDate blogDatePublished;
    @NotEmpty(message = "You must supply a value for a Blog.")
    @Length(max = 45, message = "Blog Title must be no more than 45 characters in length.")
    String blogTitle;
    @NotEmpty(message = "You must supply a value for the Blog.")
    @Length(max = 50, message = "the Blog must be no more than 500 characters in length.")
    String blogArticle;
    int userBlogUserBlogId;
    int categoryCategoryId;

    public int getUserBlogUserBlogId() {
        return userBlogUserBlogId;
    }

    public void setUserBlogUserBlogId(int userBlogUserBlogId) {
        this.userBlogUserBlogId = userBlogUserBlogId;
    }

    public int getCategoryCategoryId() {
        return categoryCategoryId;
    }

    public void setCategoryCategoryId(int categoryCategoryId) {
        this.categoryCategoryId = categoryCategoryId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogPublished() {
        return blogPublished;
    }

    public void setBlogPublished(String blogPublished) {
        this.blogPublished = blogPublished;
    }

    public String getBlogDeleted() {
        return blogDeleted;
    }

    public void setBlogDeleted(String blogDeleted) {
        this.blogDeleted = blogDeleted;
    }

    public LocalDate getBlogDatePublished() {
        return blogDatePublished;
    }

    public void setBlogDatePublished(LocalDate blogDatePublished) {
        this.blogDatePublished = blogDatePublished;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogArticle() {
        return blogArticle;
    }

    public void setBlogArticle(String blogArticle) {
        this.blogArticle = blogArticle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.blogId);
        hash = 79 * hash + Objects.hashCode(this.blogPublished);
        hash = 79 * hash + Objects.hashCode(this.blogDeleted);
        hash = 79 * hash + Objects.hashCode(this.blogDatePublished);
        hash = 79 * hash + Objects.hashCode(this.blogTitle);
        hash = 79 * hash + Objects.hashCode(this.blogArticle);
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
        final Blog other = (Blog) obj;
        if (!Objects.equals(this.blogTitle, other.blogTitle)) {
            return false;
        }
        if (!Objects.equals(this.blogArticle, other.blogArticle)) {
            return false;
        }
        if (!Objects.equals(this.blogId, other.blogId)) {
            return false;
        }
        if (!Objects.equals(this.blogPublished, other.blogPublished)) {
            return false;
        }
        if (!Objects.equals(this.blogDeleted, other.blogDeleted)) {
            return false;
        }
        if (!Objects.equals(this.blogDatePublished, other.blogDatePublished)) {
            return false;
        }
        return true;
    }

}
