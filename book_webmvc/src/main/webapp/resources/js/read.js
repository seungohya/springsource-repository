/**
 * 
 */

document.querySelector(".btn-primary").addEventListener("click",()=>{
	location.href=path;
})
document.querySelector(".btn-success").addEventListener("click",()=>{
	location.href=modifyPath+"?code="+code;
})