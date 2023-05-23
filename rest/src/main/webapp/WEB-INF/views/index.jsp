<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>도서정보</h3>
		<div>
		<input type="text" name = "code" id = "code" />
		<button type="button" class="btn btn-info">도서 상세 조회</button>
		<button type="button" class="btn btn-danger">도서 삭제</button>
		</div>
		<button type="button" class="btn btn-primary">도서 전체 목록</button>
		<div id="result" class="mt-3">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">code</th>
						<th scope="col">title</th>
						<th scope="col">writer</th>
						<th scope="col">price</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td></td>
						<td></td>
						<td></td>
					</tr>

				</tbody>
			</table>
		</div>
		<form action="" method="post" id= "insertForm">
	<div class="mb-3">
		<label for="code" class="form-label">code</label> <input type="text"
			class="form-control" id="insertCode" name="code" value="${dto.code}"
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
	</div>
	<form action="" method="post" id= "updateForm">
	<div class="mb-3">
		<label for="code" class="form-label">code</label> <input type="text"
			class="form-control" id="updateCode" name="code" value="${dto.code}"
			placeholder="도서 코드">
	</div>
		
	<div class="mb-3">
		<label for="price" class="form-label">price</label> <input type="text"
			class="form-control" id="updatePrice" name="price" value="${dto.price}"
			placeholder="도서가격">
	</div>
	
	<button type="submit" class="btn btn-primary">수정</button>

</form>
</body>
<script src="/resources/book.js"></script>
</html>