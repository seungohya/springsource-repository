/**
 * 폼 모든 요소가 비어있는지 확인
 */
const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
 /* event.preventDefault(); // 기본 동작 취소
  const inputs = form.querySelectorAll('input');
  let isEmpty = false;
  inputs.forEach((input) => {
    if (!input.value) {
      isEmpty = true;
    }
  });
  if (isEmpty) {
    alert('폼 안에 모든 요소를 입력해주세요.');
  } else {
    form.submit();
  }*/
 
	 if(!form.checkValidity()){
	  event.preventDefault();
	  event.stopPropagation();
  }form.classList.add("was-validated");
})
document.querySelector(".btn-danger").addEventListener('click',()=>{
  const userid = document.querySelector("#userid").value;
  fetch("/member/dupId", {
    method: "post",
    body: new URLSearchParams({ userid: userid })
  })
    .then((response) => response.text())
    .then((result) => {
      console.log(result);
      if (result.trim() == "true") {
        alert("아이디를 사용할 수 있습니다.");
      } else {
        alert("아이디를 사용할 수 없습니다.");
      }
    });
});
