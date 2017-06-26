<%-- 
    Document   : adminPage
    Created on : Jun 26, 2017, 9:52:35 AM
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
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/editPost.jsp">
                            Edit Post
                        </a>
                    </li>
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath}/editPage.jsp">
                            Edit Page
                        </a>
                    </li>    
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/adminPage.jsp">
                            Edit Page
                        </a>
                    </li> 
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/editPost.jsp">
                            Edit Post
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/editPage.jsp">
                            Edit Page
                        </a>
                    </li> 
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/adminPage.jsp">
                            Edit Page
                        </a>
                    </li> 
                </ul>
            </div>
            <div class="row">
    <!-- 
        Add a col to hold the summary table - have it take up half the row 
    -->
    <div class="col-md-6">
        <h2>Admin Page</h2>
        <table id="adminTable" class="table table-hover">
            <tr>
                <th width="20%">Date</th>
                <th width="40%">Title</th>
                <th width="20%">Published</th>
                <th width="20%">Deleted</th>
            </tr>
            <c:forEach var="currentBlog" items="${blogList}">
            <tr>
                <td>
                    <c:out value="${currentBlog.blogDatePublished}"/>
                </td>
                <td>
                    <c:out value="${currentBlog.blogTitle}"/>
                </td>
                <td>
                    <c:out value="${currentBlog.blogPublished}"/>
                </td>
                <td>
                    <c:out value="${currentBlog.blogDeleted}"/>
                </td>
                
            </tr>
        </table>                    
    </div> <!-- End col div -->

            
                       
                       
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
