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

document.querySelector(".btn-danger").addEventListener("click", () => {
  form.action = "/board/remove";
  form.submit();
});
