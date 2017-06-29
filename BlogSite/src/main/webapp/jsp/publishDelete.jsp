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
                <li role="presentation" class="active">
                    <a href="${pageContext.request.contextPath}/displayPublishDelete">
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
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h4>Hello : ${pageContext.request.userPrincipal.name}
                | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
            </h4>
        </c:if>
        <br/>
        <div class="col-md-8">
            <div method="GET">
                <h3><c:out value="${categorySelected}"/></h3></div>
            <br/>
            <table id="blogTable" class="table table-hover">
                <tr><th width="10%">DATE</th>
                    <th width="45%">TITLE</th>
                    <th width="15%">AUTHOR</th>
                    <th width="10%">PUBLISHED?</th>
                    <th width="10%">DELETED?</th>
                    <th width="10%">ACTION</th>
                </tr>
                <c:forEach var="currentItem" items="${blogList}">
                    <tr>
                        <td style="font-size: 12pt"><c:out value="${currentItem.blogDatePublished}"/></td>
                        <td style="font-size: 14pt"><c:out value="${currentItem.blogTitle}"/></td>
                        <td style="font-size: 14pt">To Be Coded</td>
                        <td style="font-size: 14pt; text-align: center"><c:out value="${currentItem.blogPublished}"/></a></td>
                        <td style="font-size: 14pt; text-align: center"><c:out value="${currentItem.blogDeleted}"/></td>
                        <td style="font-size: 11pt">
                            <div><a href="updatePublish?blogId=${currentItem.blogId}"> PUBLISH </a></div>
                            <div><a href="updateDelete?blogId=${currentItem.blogId}"> DELETE </a></div>
                            <div><a href="updateRecover?blogId=${currentItem.blogId}"> RECOVER </a></div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-2">
            <h3>Filter by Topic</h3>
            <c:forEach var="currentItem" items="${categoryList}">
                <form action="getAllBlogsByCategoryPublishDelete" method="GET">
                    <button type ="submit"
                            name="selectedCat"
                            class="col-md-11 btn btn-default"
                            style="font-size: 13pt"
                            id="${currentItem.categoryId}"
                            value="${currentItem.categoryId}">
                        <c:out value="${currentItem.categoryName}"/>
                    </button>
                </form>
            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
