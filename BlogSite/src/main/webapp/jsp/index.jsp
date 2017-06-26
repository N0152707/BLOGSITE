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
                </ul>
            </div>
            <br/>
            <h3>Insert Category Name</h3>
            <br/>
            <div class="col-md-10"> 
                <table id="blogTable" class="table table-hover">
                    <tr>
                        <th width="65%">Post Title</th>
                        <th width="35%">Date</th>
                    </tr>
                    <c:forEach var="currentItem1" items="${blogList}">
                        <tr>
                            <td><c:out value="${currentItem1.blogTitle}"/></td>
                            <td><c:out value="${currentItem1.blogDatePublished}"/></td>
                        </tr>
                        <tr>
                            <td><c:out value="${currentItem1.blogArticle}"/></td>
                        </tr>
                   </c:forEach>
                </table>
            </div>
            <div class="col-md-2">
                <h3>Categories</h3>
                <div class="col-md-11">
                    <c:forEach var="currentItem2" items="${categoryList}">
                        <button type ="button"
                                class="col-md-11 btn btn-default"
                                style="margin: 10px"
                                id="${currentItem2.categoryId}">
                            <c:url value="/displayCategoriesPage" var="myUrl"> 
                                <a href="displayCategoriesPage?categoryId=${currentCategory.categoryId}"> 
                                <c:out value="${currentItem2.categoryName}"/>
                                </a>
                            </c:url>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        
    </body>
</html>