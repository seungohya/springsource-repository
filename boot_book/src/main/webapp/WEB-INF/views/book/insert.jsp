<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<h1>도서 정보 입력</h1>
<form action="" method="post">
	<div class="mb-3">
		<label for="code" class="form-label">code</label> <input type="text"
			class="form-control" id="code" name="code" value="${dto.code}"
			placeholder="도서 코드">
	</div>
	<div class="mb-3">
		<label for="title" class="form-label">title</label> <input type="text"
			class="form-control" id="title" name="title" value="${dto.title}"
			placeholder="도서명">
	</div>
	<div class="mb-3">
		<label for="writer" class="form-label">writer</label> <input
			type="text" class="form-control" id="writer" name="writer"
			value="${dto.writer}" placeholder="저자명">
	</div>
	<div class="mb-3">
		<label for="price" class="form-label">price</label> <input type="text"
			class="form-control" id="price" name="price" value="${dto.price}"
			placeholder="도서가격">
	</div>
	<div class="mb-3">
		<label for="description" class="form-label">description</label>
		<textarea class="form-control" id="description" name="description"
			placeholder="상세정보">${dto.description}</textarea>
	</div>
	<button type="submit" class="btn btn-primary">저장</button>
	<button type="button" class="btn btn-primary" id="btn-list">목록으로</button>

</form>
<script src="<c:url value='/js/insert.js' />"></script>
<script>
const path = "<c:url value='/book/list'/>";
document.getElementById("btn-list").addEventListener("click", function() {
  location.href = path;
});
</script>
<%@ include file="../include/footer.jsp"%>
