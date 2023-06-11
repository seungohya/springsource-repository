<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<h1>도서 목록</h1>

<form action='<c:url value="/book/search"/>' id="search-form" class="row g-3 justify-content-center">
	<div class="col-auto">
		<select class="form-selet" name="criteria">
			<option ${searchDTO.criteria == 'null' ? 'selected' : ''}>검색기준 선택</option>
			<option value="writer" ${searchDTO.criteria == 'writer' ? 'selected' : ''}>작가</option>
			<option value="title" ${searchDTO.criteria == 'title' ? 'selected' : ''}>제목</option>

		</select>
	</div>

	<div class="col-md-5">
		<input type="text" class="form-control" name="keyword" placeholder="검색어" value='${searchDTO.keyword}'>
	</div>
	<div class="col-auto">
		<button type="submit" class="btn btn-secondary">검색</button>
	</div>
</form>
<table class="table">
	<thead>
		<tr>
			<th>code</th>
			<th>title</th>
			<th>writer</th>
			<th>price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.code}</td>
				<td><a href='<c:url value="/book/read?code=${dto.code}"/>'>${dto.title}</a></td>

				<td>${dto.writer}</td>
				<td>${dto.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script src='<c:url value = "/js/list.js"/>'></script>
<%@ include file="../include/footer.jsp"%>