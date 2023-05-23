/**
 * 버튼 클릭 시 도서 전체 목록 가져오기
 *
 * 화면 깜빡임 없이 데이터를 가져오기 = > ajax
 * ajax  : fetch , jquery , axios
 */

document.querySelector(".btn-primary").addEventListener("click", () => {
  //fetch("경로").then(서버로 오는 데이터 받기(적절한 타입으로 변환)).then(화면 출력).catch(에러);
  fetch("/list")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      let result = "";
      data.forEach((item) => {
        result += "<tr>";
        result += "<th scope='row'>" + item.code + "</th>";
        result += "<td>" + item.title + "</td>";
        result += "<td>" + item.writer + "</td>";
        result += "<td>" + item.price + "</td>";
        result += "</tr>";
      });
      document.querySelector("#result tbody").innerHTML = result;
    })
    .catch((error) => console.log(error));
});

document.querySelector(".btn-info").addEventListener("click", () => {
  const codeInput = document.querySelector("#code").value;
  const url = `/${codeInput}`;

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error("URL 확인");
      }
      return response.json();
    })
    .then((item) => {
      console.log(item);
      let result = "";
      result += "<tr>";
      result += "<th scope='row'>" + item.code + "</th>";

      result += "<td>" + item.title + "</td>";

      result += "<td>" + item.writer + "</td>";

      result += "<td>" + item.price + "</td>";

      result += "<td>" + item.description + "</td>";
      result += "</tr>";

      document.querySelector("#result tbody").innerHTML = result; // Set the HTML content of tbody element
    })
    .catch((error) => console.log(error));
});

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
  e.preventDefault(); //submit 전송 중지
  //폼 안의 데이터 가져오기
  //자바스크립트 객체로 생성
  //{code: ""} 자바스크립트 객체
  let data = {
    code: document.querySelector("#insertCode").value,
    title: document.querySelector("#title").value,
    writer: document.querySelector("#writer").value,
    price: document.querySelector("#price").value,
    description: document.querySelector("#description").value,
  };
  //JSON.stringify(data) : 자바스크립트 객체를 json 형태로 변환 해주는 함수
  fetch("/create", {
    method: "post",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("데이터 확인");
      }
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("입력 성공");
      }
    })
    .catch((error) => alert(error));
});

// 삭제 버튼 클릭 시 코드 가져온 후 삭제
document.querySelector(".btn-danger").addEventListener("click", () => {
  // 입력한 코드 가져오기
  let code = document.querySelector("#code").value;
  fetch("/" + code, {
    method: "delete",
  })
    .then((response) => {
      if (!response.ok) throw new Error("데이터 확인");
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("삭제 성공");
      }
    })
    .catch((error) => {
      alert(error);
    });
});

const updateForm = document.querySelector("#updateForm");

updateForm.addEventListener("submit", (e) => {
  e.preventDefault();

  // updateForm 안의 데이터 가져와서 자바스크립트 객체로 생성
  let data = {
    code: document.querySelector("#updateCode").value,
    price: document.querySelector("#updatePrice").value,
  };

  fetch("/update", {
    method: "PUT",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("데이터 확인");
      }
      return response.text();
    })
    .then((data) => {
      if (data === "success") {
        alert("수정 성공");
      }
    })
    .catch((error) => alert(error));
});
