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
                    <a href="${pageContext.request.contextPath}/displayPublishDelete">
                        Publish/Delete Post
                    </a>
                </li>
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/addStaticPost.jsp">
                        Static Example  </a>
                </li>
            </ul>
        </div>
        <div class="col-md-11">
            <br/>
            <h3>Add Post</h3>
            <h5>Write your post below!</h5>
            <div class="col-md-11">
                <sf:form class="form-horizontal"
                         role="form" method="POST"
                         modelAttribute="blog"
                         action="createBlog">
                    <div class="form-group">
                        <label for="add-Title">Title: </label>
                        <sf:input type="text" class="form-control" id="blogTitle"
                                  path="blogTitle" placeholder="Enter Title"/>
                        <sf:errors path="blogTitle" cssclass="error"></sf:errors>
                        </div>
                        <div class="form-group">
                            <label for="add-categoryId">Category: </label>
                        <sf:input type="text" class="form-control" id="categoryCategoryId"
                                  path="categoryCategoryId" placeholder="Enter Category (number)"/>
                        <sf:errors path="categoryCategoryId" cssclass="error"></sf:errors>
                        </div>
                        <div class="form-group">
                            <label for="add-Author">Author: </label>
                            <div id="addAuthor" class="form-control" value="${userId}">
                            <c:out value="${firstName}"/> <c:out value="${lastName}"/>
                        </div>
                    </div>
                    <label for="add-Author"></label>
                    <textarea id="blogText" path="blogArticle" name="blogArticle">

                    </textarea>
                    <div class="form-group">
                        <br/>
                        <input type="submit"
                               class="btn btn-default"
                               value="Add Post"
                               onclick="/createBlog;/addTags"></input>

                    </div>
                </sf:form>
                <form>Tags:
                    <div class="form-group">
                        <label for="add-tagName" class="control-label"></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="tagName1" placeholder="Enter tag"/>
                        </div>
                        <label for="add-tagName" class="control-label"></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="tagName2" placeholder="Enter tag"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-tagName" class="control-label"></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="tagName3" placeholder="Enter tag"/>
                        </div>
                        <label for="add-tagName" class="control-label"></label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="tagName4" placeholder="Enter tag"/>
                        </div>
                    </div>







            </div>

            <br/><br/>
        </div>
    </div>

    <script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
