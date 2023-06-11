const btnPrimary = document.querySelector(".btn-primary");
if (btnPrimary) {
  btnPrimary.addEventListener("click", () => {
    location.href = path;
  });
}

const btnSuccess = document.querySelector(".btn-success");
if (btnSuccess) {
  btnSuccess.addEventListener("click", () => {
    location.href = modifyPath + "?code=" + code;
  });
}
