<%--
    Document   : editPost
    Created on : Jun 24, 2017, 3:43:02 PM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyStreamOfConsciousnessBlog</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>MyStreamOfConsciousnessBlog</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/index">
                            Home
                        </a>
                    </li>
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath}/displayAddPost">
                            Add Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displaySelectEditPost">
                            Select To Edit
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayPublishDelete">
                            Publish/Delete Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/aboutUs.jsp">
                            Static Example
                        </a>
                    </li>
            </div>

            <h2>Edit Post</h2>
            <h5>Edit you post in the window below</h5>
            <div class="col-md-12">

                <sf:form class="form-horizontal" role="form" modelAttribute="blog"
                         action="editBlogForm" method="POST">
                    <div class="form-group">
                        <label for="add-blogTitle" class="control-label">Title:</label>

                        <sf:input type="text" class="form-control" id="add-blogTitle"
                                  path="blogTitle" placeholder="blogTitle"/>
                        <sf:errors path="blogTitle" cssclass="error"></sf:errors>
                        </div>

                        <textarea id="blogId" name="blogArticle">${blog.blogArticle};
                    </textarea>
                    <sf:hidden path="blogId"/>
                    <br/>
                    <div class="form-group">
                        <div class="align-right">
                            <button type="submit" class="btn btn-default">Edit Blog</button>
                        </div>
                    </div>
                </sf:form>
            </div>






































            <!--
                <div class="container">
                <div class="row col-md-12">
                    <div class="col-md-10 col-md-offset-1">
                        <br/><br/>
                        <form method="post">
                            <input type="date" id="blogDate" >
                            <input type="text" id="blogTitle" placeholder="Title of blog post">
                             <input type="text" id="categoryName" placeholder="Category Name">
                             <input type="text" id="tagName" placeholder="Tag Name">

                            <textarea id="blogText"></textarea>
                        </form>
                        <input type="submit" value="save">
                        <input type="submit" value="edit">
                    </div>
                </div>
            </div>-->

            <!-- javascript -->

            <script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
            <script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>





