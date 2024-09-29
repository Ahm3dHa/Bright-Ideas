<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>${user.alias}'s Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/profile_style.css">
</head>
<body>
    <header>
        <h1>${user.alias}'s Profile</h1>
    </header>

    <div class="container">
        <p>Name: ${user.username}</p>
        <p>Email: ${user.email}</p>
        <p>Total Posts: ${totalPosts}</p>
        <p>Total Likes: ${totalLikes}</p>

        <div class="link-container">
            <a href="/welcome">Bright Ideas</a>
            <a href="/logout" class="logout-button">Logout</a>
        </div>
    </div>
</body>
</html>
