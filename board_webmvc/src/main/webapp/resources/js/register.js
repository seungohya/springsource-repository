/**
 *
 */
const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  //form.checkValidity (): 부트스트랩에서 제공하는 함수
  e.preventDefault();
  if (!form.checkValidity()) {
    // e.stopPropagation(); //이벤트 전파 막기위함
    form.classList.add("was-validated");
  }
  //첨부파일 정보를 hidden 으로 담아서 폼 전송하기
  //게시글 내용이 작성이 다된다고 해도 폼은 못가게 막기
  //첨부파일 정보 수집하기
  else {
    const list = document.querySelectorAll(".uploadResult ul li");
    console.log(list);
    let str = "";
    list.forEach((ele, idx) => {
      // console.log("path", ele.dataset.path);
      // console.log("uuid", ele.dataset.uuid);
      // console.log("fileName", ele.dataset.filename);
      // console.log("type", ele.dataset.type);

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
    form.insertAdjacentHTML("beforeend", str);
    console.log(form);
    form.submit();
  }
});
