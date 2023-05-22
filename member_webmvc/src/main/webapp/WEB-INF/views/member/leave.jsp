<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<main class="form-signin w-100 m-auto">
    <form method="post" action="<c:url value='/member/leave'/>" novalidate>
        <h1 class="h3 mb-3 fw-normal">회원탈퇴 변경</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="userid"
                placeholder="userid" name="userid" value = '${loginDTO.userid}'required> <label
                for="userid" >아이디</label>
                <div class="invalid-feedback">아이디</div>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword1"
                placeholder="current password" name="password" required> <label
                for="floatingPassword1">현재 비밀번호</label>
                <div class="invalid-feedback">비밀번호를 확인해 주세요</div>
        </div>
       
        <button class="w-100 btn btn-lg btn-primary" type="submit">회원 탈퇴</button>
    </form>
</main>
</body>

<%@ include file="../include/footer.jsp"%>
</html>