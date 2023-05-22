<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Board List</h1>
</div>
<div class="d-flex">
	<!-- 검색 부분  -->
	<div class="flex-grow-1 pb-2 justify-content-between">
  <form action="" id="searchForm">
    <!-- 검색결과는 무조건 1 페이지부터 봐야해서 먼저 설정해줌 -->
    <input type="hidden" name="page" value="1" />
    <input type="hidden" name="amount" value="${criteria.amount}" />
    <div class="form-row">
      <div class="form-group col-3">
        <select name="type" id="type" class="form-control">
          <option value="" <c:out value="${criteria.type == '' ? 'selected' : ''}"/>>------------</option>
          <option value="T" <c:out value="${criteria.type == 'T' ? 'selected' : ''}"/>>제목</option>
          <option value="C" <c:out value="${criteria.type == 'C' ? 'selected' : ''}"/>>내용</option>
          <option value="W" <c:out value="${criteria.type == 'W' ? 'selected' : ''}"/>>작성자</option>
          <option value="TC" <c:out value="${criteria.type == 'TC' ? 'selected' : ''}"/>>제목 or 내용</option>
          <option value="TW" <c:out value="${criteria.type == 'TW' ? 'selected' : ''}"/>>제목 or 작성자</option>
          <option value="TCW" <c:out value="${criteria.type == 'TCW' ? 'selected' : ''}"/>>제목 or 내용 or 작성자</option>
        </select>
      </div>
      <div class="form-group col-5">
        <input type="text" class="form-control" name="keyword" id="keyword" value="${criteria.keyword}" />
      </div>
      <div class="form-group col-3">
        <button type="submit" class="btn btn-info" id="searchBtn">검색</button>
      </div>
    </div>
  </form>
</div>

	<!--검색 종료  -->
	<div class="pb-2 px-2">

		<select name="amount" id="amount" class="form-control">

			<option value="10" <c:out value = "${pageDTO.criteria.amount == 10?'selected':'' }"/>>10</option>
			<option value="20" <c:out value = "${pageDTO.criteria.amount == 20?'selected':'' }"/>>20</option>
			<option value="30" <c:out value = "${pageDTO.criteria.amount == 30?'selected':'' }"/>>30</option>
			<option value="40" <c:out value = "${pageDTO.criteria.amount == 40?'selected':'' }"/>>40</option>
		</select>
	</div>
	<div class="pb-2">
		<button class="btn btn-xs btn-success" type="button" onclick="location.href = '/board/register'">Register New Board</button>
	</div>
</div>
<table class="table table-striped table-boardered table-hover">
	<thead>
		<tr>
			<th scope="col">번호</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">작성일</th>
			<th scope="col">수정일</th>
		</tr>
	</thead>
	<tbody>
		<!-- 전체 리스트 출력 -->
		<c:forEach items="${list}" var="list">
			<tr>
				<td scope="row">${list.bno}</td>
				<td><a href="${list.bno}" class="move">${list.title}</a></td>
				<td>${list.writer}</td>
				<td>${list.regdate}</td>
				<td>${list.updatedate}</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이지 나누기 시작  -->
<nav aria-label="...">
	<ul class="pagination justify-content-center">
		<c:if test="${pageDTO.prev}">
			<li class="page-item"><a class="page-link" href="${pageDTO.startPage - 1}">Previous</a></li>
		</c:if>
		<c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}" var="idx">
			<li class="page-item ${pageDTO.criteria.page == idx ? 'active' : ''}"><a class="page-link" href="${idx}">${idx}</a></li>
		</c:forEach>
		<c:if test="${pageDTO.next}">
			<li class="page-item"><a class="page-link" href="${pageDTO.endPage + 1}">Next</a></li>
		</c:if>
	</ul>
</nav>

<!-- 페이지 나누기 종료 -->
<!-- Modal -->
<div class="modal" tabindex="-1" id="registerModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">게시글 등록</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>처리가 완료되었습니다.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

			</div>
		</div>
	</div>
</div>
<!-- 페이지 나누기 링크 처리를 위한 폼 -->
<form action="/board/list" id="operForm">
	<input type="hidden" name="page" value="${pageDTO.criteria.page}" />
	<input type="hidden" name="amount" value="${pageDTO.criteria.amount}" />

</form>
<script>
	const result = '${result}';
</script>
<script src="/resources/js/list.js"></script>
<%@ include file="../include/footer.jsp"%>

						