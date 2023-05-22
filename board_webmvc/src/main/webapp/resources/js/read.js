/**
 *
 */
//수정 버튼 클릭 시 operForm 보내기
// /board/read 로 전송
const form = document.querySelector("#operForm");
document.querySelector(".btn-info").addEventListener("click", () => {
  form.action = "/board/modify";
  form.submit();
});

//목록 버튼을 클릭 시 operFrom 보내기
// /board/list 로 전송
// bno 제거
document.querySelector(".btn-secondary").addEventListener("click", () => {
  form.firstElementChild.remove();
  form.action = "/board/list";
  form.submit();
});
window.onpageshow = function (event) {
  // 뒤로가기 버튼을 클릭할 때 수행할 동작을 여기에 작성합니다.
  if (event.persisted) {
    location.reload();
  }
};
