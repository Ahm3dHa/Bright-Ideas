<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="/css/dashboard_style.css">
    <title>Dashboard</title>
</head>

<body>
    <header>
        <h1>Hi, ${user.username}!</h1>
        <p class="logout"><a href="/logout">Logout</a></p>
    </header>

    <div class="container">
        <div class="form-container">
            <form action="/posts/new" method="post">
                <textarea name="content" rows="4" cols="50" placeholder="Share your idea..." class="form-control" required></textarea>
                <input type="submit" value="Post" />
            </form>

            <h2>IDEAS :</h2>
            <c:if test="${empty posts}">
                <p>No posts available.</p>
            </c:if>
            <hr>
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <div class="post-header">
                        <span><a href="/profile/${post.user.id}" class="alias">${post.user.alias} Says:</a></span>
                    </div>
                    <div class="post-content-box">
                        <h3 class="post-content">${post.content}</h3>
                    </div>
                    <a href="<c:url value='/posts/${post.id}/likestatus'/>">
                        <p>${post.likedBy.size()} people like this post</p>
                    </a>
                    <form action="/posts/${post.id}/like" method="post">
                        <button type="submit">Like</button>
                    </form>
                    <p>Liked by:
                        <c:forEach var="liker" items="${post.likedBy}">
                            <c:choose>
                                <c:when test="${not empty liker.username}">
                                    ${liker.username}
                                </c:when>
                                <c:otherwise>
                                    Anonymous
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </p>
                    <c:if test="${post.user.id == user.id}">
                        <form action="/posts/${post.id}/delete" method="post">
                            <button type="submit">Delete</button>
                        </form>
                    </c:if>
                </div>
                <hr>
            </c:forEach>
        </div>
    </div>
</body>

</html>
