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
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayAddStaticPost">
                            Static Example
                        </a>
                    </li>
                </ul>
            </div>
            <br/>
            <div class="col-md-6">
                <h3>Add Post</h3>
                <h5>Add your post in the below windows</h5>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createStaticBlog">
                    <div class="form-group">
                        <label for="add-blogStaticTitle" class="col-md-4 control-label">blogStaticTitle:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="blogStaticTitle" placeholder="blogStaticTitle"/>
                        </div>
                    </div>
                    
                    
<!--                      <div class="form-group">
                        <label for="add-categoryId" class="col-md-4 control-label">categoryId":</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="categoryId" placeholder="categoryId"/>
                        </div>
                    </div>
                    
                    
                       <div class="form-group">
                        <label for="add-userBlogId" class="col-md-4 control-label">userBlogId":</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="userBlogId" placeholder="userBlogId"/>
                        </div>
                    </div>-->

                    <textarea id="blogText" name="blogStaticArticle" > </textarea>
<!--
                    <div class="form-group">
                        <label for="add-tagName" class="col-md-4 control-label">tagName:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="tagName" placeholder="tagName"/>
                        </div>
                    </div>-->

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Static Blog"/>
                        </div>
                    </div>
                </form>
                <br/><br/>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
