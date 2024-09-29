<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Like Status</title>
    <link rel="stylesheet" href="<c:url value='/css/like_style.css'/>">
</head>
<body>
    <header>
        <div class="header-container">
            <h1>Like Status</h1>
            <nav>
                <a class="btn" href="<c:url value='/welcome'/>">Bright Ideas</a>
                <a class="btn" href="<c:url value='/logout'/>">Logout</a>
            </nav>
        </div>
    </header>

    <div class="container">
        <h2>Post Idea</h2>
        <p class="idea-content"><strong>Idea:</strong> ${post.content}</p>
        <p class="posted-by"><strong>Posted by:</strong> <a href="<c:url value='/profile/${post.user.id}'/>">${post.user.alias}</a></p>

        <h3>People Who Liked This Post:</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Alias</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${post.likedBy}">
                    <tr>
                        <td>
                            <a href="<c:url value='/profile/${user.id}'/>">${user.alias}</a>
                        </td>
                        <td>${user.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
