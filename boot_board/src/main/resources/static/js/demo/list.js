/**
 *
 */
checkModal(result);
function checkModal(result) {
  if (result === "") return;

  if (parseInt(result) > 0) {
    document.querySelector(".modal-body").innerHTML =
      "게시글" + result + "번이 등록되었습니다.";
  }
  document.querySelector("#registerModal").modal("show");
}
