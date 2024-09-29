<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <title>Login and Registration</title>
</head>
<body>
    <header>
        <h1>Ignite Your Imagination: Share Your Ideas with Us!</h1>
    </header>
    <div class="container ${errors.hasErrors ? 'sign-up-mode' : ''}" id="container">
        <div class="form-container" id="form-container">
            <div class="form-section login-section" id="login-section">
                <h1>Sign In</h1>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    <form:input type="email" placeholder="Email" path="email" class="form-control"/>
                    <form:errors path="email" class="error"/>
                    <form:input type="password" placeholder="Password" path="password" class="form-control"/>
                    <form:errors path="password" class="error"/>
                    <input type="submit" value="Submit" />
                </form:form>
            </div>

            <div class="form-section register-section" id="register-section">
                <h1>Sign Up</h1>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <form:input type="text" placeholder="Username" path="username" class="form-control"/>
                    <form:errors path="username" class="error"/>
                    <form:input type="email" placeholder="Email" path="email" class="form-control"/>
                    <form:errors path="email" class="error"/>
                    <form:input type="password" placeholder="Password" path="password" class="form-control"/>
                    <form:errors path="password" class="error"/>
                    <form:input type="password" placeholder="Confirm Password" path="confirm" class="form-control"/>
                    <form:errors path="confirm" class="error"/>
                    <form:input type="text" placeholder="Alias" path="alias" class="form-control"/>
                    <form:errors path="alias" class="error"/>
                    <input type="submit" value="Submit" />
                </form:form>
            </div>

            <div class="right-panel" id="right-panel">
                <h2 id="toggle-text">Don't have an account? Please Sign Up!</h2>
                <a href="javascript:void(0)" id="toggle-btn">SIGN UP</a>
            </div>
        </div>
    </div>

    <script>
        const formContainer = document.getElementById('form-container');
        const toggleBtn = document.getElementById('toggle-btn');
        const toggleText = document.getElementById('toggle-text');
        const container = document.getElementById('container');

        if (sessionStorage.getItem('showRegister') === 'true') {
            container.classList.add('sign-up-mode');
        }

        toggleBtn.addEventListener('click', () => {
            if (container.classList.contains('sign-up-mode')) {
                container.classList.remove('sign-up-mode');
                sessionStorage.setItem('showRegister', 'false');
                toggleText.textContent = "Don't have an account? Please Sign Up!";
                toggleBtn.textContent = "SIGN UP";
            } else {
                container.classList.add('sign-up-mode');
                sessionStorage.setItem('showRegister', 'true');
                toggleText.textContent = "Already have an account? Please Sign In!";
                toggleBtn.textContent = "SIGN IN";
            }
        });
    </script>
    
    <style>
        header {
            background-color: #cba565;
            color: white;
            text-align: center;
            padding: 20px 0;
            margin-bottom: 20px;
        }

        header h1 {
            margin: 0;
            font-size: 28px;
        }
    </style>
</body>
</html>
