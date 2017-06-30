<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                        <a href="${pageContext.request.contextPath}/displayPublishDelete">
                            Publish/Delete Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/aboutUs.jsp">
                            Static Example
                        </a>
                    </li>
                    
                     <li role="presentation">
                        <a href="${pageContext.request.contextPath}/aboutUs">
                            Add Post
                        </a>
                    </li>
                    
                    
                    
                    
                </ul>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h4>Hello : ${pageContext.request.userPrincipal.name}
                    | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </h4>
            </c:if>

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
            <div class="col-md-11">
                <h3>Add Post</h3>
                <h5>Add your post in the below windows</h5>
                <form class="form-horizontal"
                      role="form" method="POST"
                      action="createBlog">
                    <div class="form-group">
                        <label for="add-blogTitle">Title: </label>
                        <input type="text" class="form-control" name="blogTitle" placeholder="blogTitle"/>
                    </div>
                    <div class="form-group">
                        <div>
                            <label for="add-categoryId" class="control-label">Category: </label>
                            <input type="text" class="form-control" name="categoryId" placeholder="categoryId"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-userBlogId" class="control-label"> userBlogId: </label>
                        <div>
                            <input type="text" class="form-control" name="userBlogId" placeholder="userBlogId"/>
                        </div>
                    </div>
                    <textarea id="blogText" name="blogArticle">

                    </textarea>
                    <div class="form-group">
                        <label for="add-tagName" class="control-label">Tag(s): </label>
                        <div>
                            <input type="text" class="form-control" name="tagName" placeholder="tagName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-8">
                            <button type="submit"
                                    class="btn btn-default"
                                    onclick="/addNewPost">Add Post</button>
                        </div>
                    </div>
                </form>
                <br/><br/>
            </div>
        </div>

        <script type="text/javascript" src="plugin/tinymce/tinymce.min.js"></script>
        <script type="text/javascript" src="plugin/tinymce/init-tinymce.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
