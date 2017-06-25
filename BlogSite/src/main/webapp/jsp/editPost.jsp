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
                        <a href="${pageContext.request.contextPath}/home.jsp">
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
                        <a href="${pageContext.request.contextPath}/editPost.jsp">
                            Edit Post
                        </a>
                    </li>
                </ul>
            </div>
            <h2>Edit Post</h2>
            <h5>Edit you post in the window below</h5>
            <div class="col-md-9">
        <form class="form-horizontal" 
              role="form" method="GET" 
              action="editBlog">
            <div class="form-group">
                <label for="display-blog-title" class="col-md-9 control-label">Blog Title:</label>
                <div class="col-md-9">
                    
                    <select id="blogTitle" class="form-control" name="blogTitle" placeholder="Blog Title"> 
                        <c:forEach var="currentBlog" items="${blogList}">
                            <option label="${currentBlog.BlogTitle}" value="<c:out value="${currentBlog.blogId}"/>
                      
                        </c:forEach>
                    </select>   
                </div>
            </div>
            </div>

            
            
            
            
            <div class="col-md-9" id="blogContent">
                <table class="col-md-11"
                       <c:forEach var="currentItem" items="${postsByCategory}">
                           <tr>
                               <td width="65%"><c:out value="$currentItem.title"/></td>
                               <td width="35%"><c:out value="$currentItem.date"/></td></tr>
                           <br/>
                           <tr width="100%"><c:out value="$currentItem.content"/></tr>
                           <tr width="100%"><c:out value="$currentItem.author"/></tr>
                       </c:forEach>
                </table>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
