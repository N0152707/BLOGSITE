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
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/author-admin.jsp">
                            Author-Admin
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/aboutUs.jsp">
                            About Us
                        </a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/editBlogForm">
                            Edit Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/adminPage.jsp">
                            Admin Page
                        </a>
                    </li> 
                </ul>
            </div>
            <h2>Edit Post</h2>
            <h5>Edit you post in the window below</h5>
            <div class="col-md-12">
                </select>   
            </div>
        </div>
    </div>

    <textarea class="tinymce">
<center>
    <h1>
    Blog Page
    </h1>
  </center>
    <div id="ImageBox">
                        <span class="col-md-4" id="imageBox1"> </span>
                        <span class="col-md-4" id="imageBox2"> </span>
                        <span class="col-md-4" id="imageBox3"> </span>
                    </div>

                <div class="col-md-12">
                    <div class="col-md-6">
                        <center><h3> Blog Title </h3></center>
                        <div id="textBox">

                    </div>
                    <div class="col-md-6">
                        <center><h3> Popular Hashtags </h3></center>
                        <center>
                            <div  id="hashtagBox">
                                <div>#hashtag1</div>
                                <div>#hashtag2</div>
                            </div>
                        </center>
                    </div>
                </div>
                </div>
    </textarea>

    <!-- javascript -->

    <script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   








</body>
</html>
