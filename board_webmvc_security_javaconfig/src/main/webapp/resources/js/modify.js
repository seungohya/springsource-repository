/**
 *
 */

//첨부파일 가져오기
fetch("/board/getAttachList?bno=" + bno)
  .then((response) => {
    if (!response.ok) {
      throw new Error("첨부파일 없음");
    }
    return response.json();
  })
  .then((data) => {
    showUploadFile(data);
  })
  .catch((error) => {
    console.error("Error", error);
  });

//수정 버튼 클릭 후 폼 submit 이 일어나면 첨부파일 목록 수집하기
const modifyForm = document.querySelector("#modifyForm");

modifyForm.addEventListener("submit", (e) => {
  //form.checkValidity (): 부트스트랩에서 제공하는 함수
  e.preventDefault();

  //첨부파일 정보를 hidden 으로 담아서 폼 전송하기
  //게시글 내용이 작성이 다된다고 해도 폼은 못가게 막기
  //첨부파일 정보 수집하기

  const list = document.querySelectorAll(".uploadResult ul li");
  console.log(list);
  let str = "";
  list.forEach((ele, idx) => {
    str +=
      "<input type ='hidden' name ='attachList[" +
      idx +
      "].uuid' value ='" +
      ele.dataset.uuid +
      "'/>";
    str +=
      "<input type ='hidden' name ='attachList[" +
      idx +
      "].uploadPath' value ='" +
      ele.dataset.path +
      "'/>";
    str +=
      "<input type ='hidden' name ='attachList[" +
      idx +
      "].fileName' value ='" +
      ele.dataset.filename +
      "'/>";
    str +=
      "<input type ='hidden' name ='attachList[" +
      idx +
      "].fileType' value ='" +
      ele.dataset.type +
      "'/>";
  });
  //수집한 태그 폼에 추가
  modifyForm.insertAdjacentHTML("beforeend", str);
  console.log("수정폼");
  console.log(modifyForm);
  modifyForm.submit();
});
const form = document.querySelector("#operForm");

// 수정 버튼 클릭 시 operForm 보내기
// /board/read 로 전송
// if (document.querySelector(".btn-info")) {
//   document.querySelector(".btn-info").addEventListener("submit", () => {
//     form.action = "/board/read";
//     form.submit();
//   });
// }

// 목록 버튼을 클릭 시 operFrom 보내기
// /board/list 로 전송
// bno 제거
document.querySelector(".btn-secondary").addEventListener("click", () => {
  form.firstElementChild.remove();
  form.action = "/board/list";
  form.submit();
});

// 삭제 버튼 클릭 시 operForm 보내기
// /board/remove 로 전송
if (document.querySelector(".btn-danger")) {
  document.querySelector(".btn-danger").addEventListener("click", () => {
    form.action = "/board/remove";
    form.submit();
  });
}
