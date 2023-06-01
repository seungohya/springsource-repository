/**
 *
 */

const form = document.querySelector("#operForm");

// 수정 버튼 클릭 시 operForm 보내기
// /board/modify 전송
document.querySelector(".btn-info").addEventListener("click", () => {
  form.action = "/board/modify";
  form.submit();
});

// 목록 버튼 클릭 시 operForm 보내기
// /board/list 전송
// bno 제거
document.querySelector(".btn-secondary").addEventListener("click", () => {
  form.firstElementChild.remove();
  form.action = "/board/list";
  form.submit();
});

let page = 1;
// 댓글 보여줄 영역 가져오기
let chat = document.querySelector(".chat");

showList(page);

function showReplyPage(total) {
  let endPage = Math.ceil(page / 10.0) * 10;
  let startPage = endPage - 9;
  let prev = startPage - 1;
  let next = false;
  if (endPage * 10 >= total) {
    endPage = Math.ceil(total / 10.0);
  }
  if (endPage * 10 < total) {
    next = true;
  }
  let str = "<ul class='pagination justify-content-center'>";
  if (prev) {
    str +=
      '<li class="page-item"><a class="page-link" href="' +
      (startPage - 1) +
      '">Previous</a></li>';
  }
  for (let idx = startPage; idx <= endPage; idx++) {
    let active = page == idx ? "active" : "";
    str +=
      '<li class="page-item ' +
      active +
      '"><a class="page-link" href="' +
      idx +
      '">' +
      idx +
      "</a></li>";
  }
  if (next) {
    str +=
      '<li class="page-item"><a class="page-link" href="' +
      (endPage + 1) +
      '">Next</a></li>';
  }
  str += "</ul>";
  document.querySelector(".card-footer").innerHTML = str;
}

//댓글 페이지 나누기 숫자 클릭 시 a 태그 동작 중지
//href 에 있는 값 가져오기
//showList(가져온 값)

document.querySelector(".card-footer").addEventListener("click", (e) => {
  e.preventDefault();
  page = e.target.getAttribute("href");
  showList(page);
});

function showList(pageNum) {
  // 현재 게시물에 대한 댓글 가져오기
  // page: page||1 => page 변수값이 존재하면 page 값 사용하고 없으면 1
  replyService.getList({ bno: bno, page: page || 1 }, (total, result) => {
    console.log("read.js에서 확인");
    console.log(total);
    console.log(result);
    if (pageNum == -1) {
      //마지막 페이지 알아내기
      page = Math.ceil(total / 10.0);
      showList(page);
      return;
    }
    // 도착한 데이터를 화면에 보여주기
    if (result == null || result.length == 0) {
      chat.innerHTML = "";
      return;
    }

    let str = "";
    for (let idx = 0; idx < result.length; idx++) {
      str +=
        "<li class='list-group-item border-bottom' data-rno='" +
        result[idx].rno +
        "'>";
      str += "<div class='d-flex justify-content-between'>";
      str +=
        "<strong class='primary-font'>" + result[idx].replyer + "</strong>";
      str +=
        "<small class='text-muted text-right'>" +
        replyService.displayTime(result[idx].replyDate) +
        "</small>";
      str += "</div>";
      str += "<p>" + result[idx].reply + "</p>";
      str += "<div class='btn-group btn-group-sm'>";
      str += "<button class='btn btn-warning' type ='button'>수정</button>";
      str += "<button class='btn btn-danger' type ='button'>삭제</button>";
      str += "</div>";
      str += "</li>";
    }
    chat.innerHTML = str;
    showReplyPage(total); //현 게시물에 달린 댓글 총 숫자를 이용한 페이지 나누기 함수 호출
  });
}

const reply = document.querySelector("#reply");
const replyer = document.querySelector("#replyer");
// 댓글 작업 호출 => 댓글 작성 버튼 클릭 시
// submit 중지, reply, replyer 가져오기
document.querySelector("#replyForm").addEventListener("submit", (e) => {
  e.preventDefault();

  replyService.add(
    { bno: bno, reply: reply.value, replyer: replyer.value },
    (result) => {
      //alert(result);
      //댓글 작성 부분 지우기
      reply.value = "";
      replyer.value = "";
      showList(-1);
    }
  );
});

//수정 버튼 클릭 시 모달 창 띄우기
chat.addEventListener("click", (e) => {
  //어느 li 에서 이벤트가 발생했느냐?
  //e.target : 이벤트 발생 대상
  //closest => 이벤트 발생 대상을 감싸고있는 부모 li 찾기
  let li = e.target.closest("li");
  console.log("이벤트 발생 위치:", li);

  //rno 가져오기 (data-* 속성값 가져오는 dataset)
  let rno = li.dataset.rno;
  console.log("rno :", rno);

  if (e.target.classList.contains("btn-warning")) {
    //댓글 하나 가져오기
    replyService.get(rno, (result) => {
      console.log(result);
      //모달 창 안에 가져온 내용 보여주기
      document.querySelector(".modal-body #rno").value = result.rno;
      document.querySelector(".modal-body #reply").value = result.reply;
      document.querySelector(".modal-body #replyer").value = result.replyer;
      $("#replyModal").modal("show");
    });
  } else if (e.target.classList.contains("btn-danger")) {
    //삭제 버튼 클릭시
    replyService.remove(rno, (result) => {
      if (result === "success") {
        alert("삭제 성공");
        showList(page);
      }
    });
  }
});

//모달 창 수정 버튼이 클릭되면 댓글 수정
document
  .querySelector(".modal-footer .btn-primary")
  .addEventListener("click", () => {
    //모달 창 안에 있는 rno, reply 가져온 후 자바스크립트 객체 생성
    const rno = document.querySelector(".modal-body #rno").value;
    const reply = document.querySelector(".modal-body #reply").value;

    //자바스크립트 객체 생성
    const replyObj = {
      rno: rno,
      reply: reply,
    };

    // replyService.update 호출
    replyService.update(replyObj, (result) => {
      // 수정 성공 또는 실패에 대한 처리
      //alert(result);
      // 추가적인 동작이 필요하다면 여기에 작성

      if (result === "success") {
        $("#replyModal").modal("hide");
        showList(page);
      }
    });
  });

//글번호에대한 첨부파일 가져오기
function showAttachFile(uploadResultArr) {
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
      str +=
        "<li data-path='" + item.uploadPath + "'data-uuid='" + item.uuid + "'";
      str +=
        "data-filename='" +
        item.fileName +
        "'data-type='" +
        item.fileType +
        "'>";
      str +=
        "<a href='/display?fileName=" +
        oriFileCallPath +
        "' data-lightbox='image'>";
      str +=
        "<div class='text-center'><img src='/display?fileName=" +
        fileCallPath +
        "'></div></a>";
      str += "<small>" + item.fileName + "</small> ";

      str += "</li>";
    } else {
      // txt 파일
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "/" + item.uuid + "_" + item.fileName
      );
      str +=
        "<li data-path='" + item.uploadPath + "'data-uuid='" + item.uuid + "'";
      str +=
        "data-filename='" +
        item.fileName +
        "'data-type='" +
        item.fileType +
        "'>";
      str += "<a href='/download?fileName=" + fileCallPath + "'>";
      str +=
        "<div class='text-center'><img src='/resources/img/txt-file.png'></div>";
      str += "<small>" + item.fileName + "</small></a>";

      str += "</li>";
    }
  });
  console.log("파일첨부 ", str);
  uploadResult.insertAdjacentHTML("beforeend", str);
}

fetch("/board/getAttachList?bno=" + bno)
  .then((response) => {
    if (!response.ok) {
      throw new Error("첨부파일 없음");
    }
    return response.json();
  })
  .then((data) => {
    showAttachFile(data);
  })
  .catch((error) => {
    console.error("Error", error);
  });
