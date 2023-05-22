/**
 * 1) 검색기준 선택 여부 확인
 * 2) 검색어 입력 되었는지 확인
 * ==> 둘다 입력이 된 경우에만 submit
 * 둘중에 하나라도 입력이 안된 경우에는 팝업창 띄우기
 * 
 * /search.do
 * 
 * Action , Service, DAO 메소드 만들기
 * 
 */
const form = document.getElementById('search-form');
form.addEventListener('submit', function(e) {
	e.preventDefault(); // submit 이벤트 기본 동작 막기

	const criteria = form.elements.criteria.value;
	const keyword = form.elements.keyword.value;


	if (criteria === '검색기준 선택' || keyword === '') {
		alert('검색 기준과 검색어를 입력하세요.');
	} else {
		this.submit(); // submit 이벤트 실행
	}
});