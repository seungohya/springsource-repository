<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!-- Page Heading -->
<!DOCTYPE html>
<html>
<head>
<title>Main Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* 레이아웃 스타일 */
.row {
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
	<div class="container">
		<h1 class="mt-4">Welcome to the Main Page</h1>
		<!--인증 (로그인) 되지 않았다면  -->
		<security:authorize access="!isAuthenticated()">
			<div class="row">
				<div class="col">
					<a href="/security/login" class="btn btn-primary btn-lg btn-block">Login</a>
				</div>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
		<div class="col">
			<a href="/security/userpage" class="btn btn-success btn-lg btn-block">User Page</a>
		</div>
		<div class="col">
			<a href="/security/adminpage" class="btn btn-info btn-lg btn-block">Admin Page</a>
		</div>
	</div>

	<!-- 여기에 내용 추가 -->
	<div class="row">
		<div class="col">
			<div class="logout">
				<form id="logoutForm" action="/logout" method="post">
					<input type="hidden" name="_csrf" value="${_csrf.token}">
					<!-- Spring Security CSRF 토큰 필드 추가 -->
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button class="btn btn-danger btn-lg">로그아웃</button>
					<input type="hidden" name="logout" value="true">
				</form>
			</div>
		</div>
	</div>
</security:authorize>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

<%@ include file="include/footer.jsp"%>
