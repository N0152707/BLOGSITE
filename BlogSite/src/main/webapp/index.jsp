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
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
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
                </ul>
            </div>
            <br/>
            <h3>Insert Category Name</h3>
            <br/>
            <div class="col-md-10" id="displayBlogPosts">
                <table id="blogList" class="table table-hover">
                    <tr>
                        <th width="65%">Post Title</th>
                        <th width="35%">Date</th>
                    </tr>
                    <c:forEach var="currentItem" items="${blogList}">
                        <tr>
                            <td>hi<c:out value="$currentItem.blogTitle"/></td>
                            <td><c:out value="$currentItem.blogDatePublished"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-2">
                <div class="col-md-11">
                    <c:forEach var="currentItem" items="${categoryList}">
                        <button type ="button"
                                class="col-md-11 btn btn-default"
                                style="margin: 10px"
                                id="${currentItem.categoryId}">
                            <c:out value="${currentItem.categoryName}"/>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
