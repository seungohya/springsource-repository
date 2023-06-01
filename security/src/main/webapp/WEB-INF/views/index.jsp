<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<!-- Page Heading -->
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <style>
        .row {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .col {
            margin: 0 10px;
        }

        .logout {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Main Page</h1>

    <div class="row">
        <div class="col">
            <a href="/login">Login</a>
        </div>
        <div class="col">
            <a href="/user">User Page</a>
        </div>
        <div class="col">
            <a href="/admin">Admin Page</a>
        </div>
    </div>

    <!-- 여기에 내용 추가 -->

    <div class="logout">
        <form id="logoutForm" action="/logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>

    <script>
        document.getElementById('logoutForm').addEventListener('submit', function (event) {
            event.preventDefault();
            // 로그아웃 처리 로직 작성
            // ...

            // 예시: 로그아웃 후 메인 페이지로 이동
            window.location.href = '/';
        });
    </script>
</body>
</html>

<%@ include file="include/footer.jsp"%>
