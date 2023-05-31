/**
 *
 */
document.querySelector("#uploadBtn").addEventListener("click", () => {
  // formData 객체 생성
  const formData = new FormData();

  // file 요소 가져오기
  let inputFiles = document.querySelector("#uploadFile").files;
  console.log(inputFiles);

  // 가져온 file 요소를 formData에 추가
  for (let i = 0; i < inputFiles.length; i++) {
    formData.append("uploadFile", inputFiles[i]);
  }
  // 비동기 formData 전송
  fetch("/uploadAjax", {
    method: "post",
    body: formData,
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("파일 업로드 실패");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      showUploadFile(data);
    })
    .catch((error) => console.log(error));
});

function showUploadFile(uploadResultArr) {
  // 도착한 데이터 (파일 업로드 정보)에서 파일 이름을 li 태그로 보여준다
  const uploadResult = document.querySelector(".uploadResult ul");
  let str = "";

  uploadResultArr.forEach((item) => {
    // fileType이 true인 경우 이미지 파일이므로 thumbnail 이미지를 보여준다
    if (item.fileType) {
      // 썸네일 이미지 경로 생성
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "/s_" + item.uuid + "_" + item.fileName
      );
      // 썸네일 이미지 클릭 ==> 원본 이미지 보여주기
      let oriFileCallPath = encodeURIComponent(
        item.uploadPath + "/" + item.uuid + "_" + item.fileName
      );
      str += "<li>";
      str +=
        "<a href='/display?fileName=" +
        oriFileCallPath +
        "' data-lightbox='image'>";
      str +=
        "<div class='text-center'><img src='/display?fileName=" +
        fileCallPath +
        "'></div></a>";
      str += "<small>" + item.fileName + "</small>";
      str +=
        "<span data-file='" + fileCallPath + "' data-type='image'>X</span>";
      str += "</li>";
    } else {
      // txt 파일
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "/" + item.uuid + "_" + item.fileName
      );
      str += "<li>";
      str += "<a href='/download?fileName=" + fileCallPath + "'>";
      str +=
        "<div class='text-center'><img src='/resources/img/txt-file.png'></div>";
      str += "<small>" + item.fileName + "</small></a>";
      str += "<span data-file='" + fileCallPath + "' data-type='file'>X</span>";
      str += "</li>";
    }
  });

  uploadResult.insertAdjacentHTML("beforeend", str);
}
//x 클릭 시 동작하는 함수 alert
//자식한테 이벤트가 일어나면 부모에게 전파 ==> 이벤트 전파
//실제 이벤트가 발생한 대상 : 자식, ==>e.target
//이벤트를 감지한 부모 ==> e.currentTarget
// 모든 .uploadResult 클래스를 가진 요소를 선택하여 각각에 이벤트 리스너 등록
document.querySelectorAll(".uploadResult").forEach((uploadResult) => {
  uploadResult.addEventListener("click", (e) => {
    // data- 에 있는 값 가져오기
    const dataFile = e.target.dataset.file;
    const dataType = e.target.dataset.type;
    console.log("파일, 타입: " + dataFile + ", " + dataType);
    const li = e.target.closest("li");
    //script 에서 <form> 태그 작성과 같은 역할
    const formData = new FormData();
    formData.append("fileName", dataFile);
    formData.append("type", dataType);

    fetch("/deleteFile", {
      method: "post",
      body: formData,
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("파일 제거 실패");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        li.remove();
      })
      .catch((error) => console.log(error));
  });
});
