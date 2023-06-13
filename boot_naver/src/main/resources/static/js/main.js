/**
 * 검색버튼 클릭시 사용자 입력값 가져오기
 * fetch("/api/restaurant/search")
 */
const searchButton = document.getElementById("searchButton");

searchButton.addEventListener("click", () => {
  const userInput = document.getElementById("searchBox").value;
  console.log("검색 이벤트 발생");

  // 기존 값 제거
  const searchResult = document.getElementById("search-result");
  searchResult.style.visibility = "hidden";

  const imageElement = document.getElementById("wish_image");
  imageElement.removeAttribute("src");

  const titleElement = document.getElementById("wish_title");
  titleElement.textContent = "";

  const categoryElement = document.getElementById("wish_category");
  categoryElement.textContent = "";

  const addressElement = document.getElementById("wish_address");
  addressElement.textContent = "";

  const roadAddressElement = document.getElementById("wish_road_address");
  roadAddressElement.textContent = "";

  const linkElement = document.getElementById("wish_link");
  linkElement.removeAttribute("href");
  linkElement.textContent = "";

  fetch(`/api/restaurant/search?query=${userInput}`)
    .then((response) => {
      if (!response.ok) {
        throw new Error("잘못된 요청");
      }
      return response.json();
    })
    .then((data) => {
      // 받아온 데이터 처리
      console.log(data);

      // search result에 정보 보여주기
      const searchResult = document.getElementById("search-result");
      searchResult.style.visibility = "visible";

      // 이미지 변경
      const imageElement = document.getElementById("wish_image");
      if (data.imageLink) {
        imageElement.src = data.imageLink;
      }
      // 다른 정보들 보여주기
      const titleElement = document.getElementById("wish_title");
      titleElement.textContent = data.title;

      const categoryElement = document.getElementById("wish_category");
      categoryElement.textContent = data.category;

      const addressElement = document.getElementById("wish_address");
      addressElement.textContent = data.address;

      const roadAddressElement = document.getElementById("wish_road_address");
      roadAddressElement.textContent = data.roadAddress;

      const linkElement = document.getElementById("wish_link");
      if (data.homePageLink) {
        linkElement.href = data.homePageLink;
        linkElement.textContent = "홈페이지";
      }
    })
    .catch((error) => {
      // 에러 처리
      console.error(error);
    });
});

// 페이지가 로드될 때 showList() 함수 호출
window.addEventListener("load", () => {
  showList();
});

// 위시리스트 추가 버튼 이벤트 처리
const wishButton = document.getElementById("wishButton");
wishButton.addEventListener("click", () => {
  // 검색 결과를 자바스크립트 객체로 생성
  const wishItem = {
    title: document.getElementById("wish_title").textContent,
    category: document.getElementById("wish_category").textContent,
    address: document.getElementById("wish_address").textContent,
    roadAddress: document.getElementById("wish_road_address").textContent,
    homePageLink: document.getElementById("wish_link").href,
    imageLink: document.getElementById("wish_image").src,
  };

  // POST request to add the wish list
  fetch("/api/restaurant", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(wishItem),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to add wish list");
      }
      return response.json();
    })
    .then((data) => {
      console.log("Wish list added successfully", data);
      // Handle success
    })
    .catch((error) => {
      console.error("Error adding wish list", error);
      // Handle error
    });
});

// wishlist 가져오기
function showList() {
  fetch("/api/restaurant/all")
    .then((response) => {
      if (!response.ok) {
        throw new Error("위시리스트를 가져오는데 실패했습니다.");
      }
      return response.json();
    })
    .then((data) => {
      let str = ""; // 누적할 문자열 변수

      data.forEach((element) => {
        const imgUrl = element.imageLink;
        const restaurantName = element.title;
        const category = element.category;
        const address = element.address;
        const roadAddress = element.roadAddress;
        const visited = element.isVisit;
        const lastVisitedAt = element.lastVisitDate;
        const visitedCount = element.visitCount;
        const websiteUrl = element.homePageLink;

        // 위시리스트 아이템에 대한 HTML을 str 변수에 추가
        str += `
          <hr class="mt-1" />
          <div class="row">
            <div class="col-sm-6 col-md-8">
              <img alt="food" class="img-thumbnail w-100" src="${imgUrl}">
            </div>
            <div class='col-sm-6 col-md-4'>
              <ul class='list-group list-group-flush'>
                <li class='list-group-item'>장소: ${restaurantName}</li>
                <li class='list-group-item'>Category: ${category}</li>
                <li class='list-group-item'>주소: ${address}</li>
                <li class='list-group-item'>도로명: ${roadAddress}</li>
                <li class='list-group-item'>방문여부: ${
                  visited ? "방문함" : "방문 안 함"
                }</li>
                <li class='list-group-item'>마지막 방문일자: ${
                  lastVisitedAt ? true : ""
                }</li>
                <li class='list-group-item'>방문횟수: ${visitedCount}</li>
                <li class='list-group-item'>
                  <a href='${websiteUrl}'>홈페이지</a>
                </li>
                <li class='list-group-item'>
                  <div class='d-grid gap-2'>
                    <button class='btn btn-primary' type='button'>방문 추가</button>
                    <button class='btn btn-warning' type='button'>위시리스트 삭제</button>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        `;
      });

      // 모든 위시리스트 아이템에 대한 HTML을 DOM에 추가
      document.getElementById("wish-list").innerHTML = str;
    })
    .catch((error) => {
      console.error(error);
    });
}
