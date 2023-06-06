<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="csrf" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../include/header.jsp"%>
<html>
<head>
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
html, body {
	height: 100%;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>

<!-- spring security 로그인 페이지 규칙
	1) post 방식으로 action="/login" 지정
	2) 아이디를 입력 받는 요소의 이름은 반드시 username 이어야 함 
	3) 비밀번호를 입력 받는 요소의 이름은 반드시 password 이어야 함
	4) post 방식으로 가는 모든 폼 안에는 csrf 토큰 값이 포함되어 있어야 함-->
<body>
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<main class="form-signin">
				<form method="post" action="<c:url value='/login' />">
					<h1 class="h3 mb-3 fw-normal">Please sign in</h1>


					<div class="form-floating">
						<input type="text" class="form-control" id="floatingInput" placeholder="userid" name="username">
						<label for="floatingInput">UserId</label>
					</div>
					<div class="form-floating">
						<input type="password" class="form-control" id="floatingPassword" placeholder="password" name="password">
						<label for="floatingPassword">Password</label>
					</div>
					<div class="checkbox mb-3">
						<label>
							<input type="checkbox" name="remember-me">
							Remember me
						</label>
					</div>
					<div>
						<span class="text-danger">${error}</span>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
					<p class="mt-5 mb-3 text-body-secondary"></p>

				</form>
			</main>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@ include file="../include/footer.jsp"%>
