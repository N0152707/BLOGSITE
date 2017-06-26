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
                    <li role="presentation" class="active">
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
                        <a href="${pageContext.request.contextPath}/adminPage.jsp">
                            Publish/Delete Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/aboutUs.jsp">
                            Static Example
                        </a>
                    </li>
                </ul>
            </div>

            <br/>

            <h3>Add Post</h3>
            <h5>Edit your post in the window below</h5>
            <div class="col-md-12">
                </select>
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
            <!-- Placed at the end of the document so the pages load faster -->

            <script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
            <script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
