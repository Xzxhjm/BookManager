//--------------------------当前必是用户
window.onload  =function (){
    const username = localStorage.getItem("p_name");
    const user_info = document.getElementById("user_info");

    user_info.innerText = username+",你好!";
}