const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  const userId = document.querySelector("#userid");
  const curPwd = document.querySelector("#floatingPassword1");
  const newPwd = document.querySelector("#floatingPassword2");
  const confirmPwd = document.querySelector("#floatingPassword3");

  if (!curPwd.value) {
    alert("현재 비밀번호를 입력해 주세요.");
    curPwd.focus();
    return;
  } else if (!newPwd.value) {
    alert("새 비밀번호를 입력해 주세요.");
    newPwd.focus();
    return;
  } else if (!confirmPwd.value) {
    alert("새 비밀번호 확인을 입력해 주세요.");
    confirmPwd.focus();
    return;
  }

  if (newPwd.value !== confirmPwd.value) {
    alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
    confirmPwd.focus();
    return;
  }

  form.submit();
});
