function fnLogin() {
    var oUname = document.getElementById("uname")
    var oUpass = document.getElementById("upass")
    var oError = document.getElementById("error_box")
    if (oUname.value.length > 20 || oUname.value.length < 6) {
        oError.innerHTML = "请输入6-20位字符"
    }

    if (oUpass.value.length > 20 || oUpass.value.length < 6) {
        oError.innerHTML = "请输入6-20位字符"
    }
}
function showDiv() {


    if(document.getElementById("container0").style.display === "block")
    {
        document.getElementById("container0").style.display = "none";
        document.getElementById("container1").style.display = "block";
    }
    else
    {
        document.getElementById("container0").style.display = "block";
        document.getElementById("container1").style.display = "none";
    }
}
window.onload=function (){
    localStorage.setItem("xzx_name","");
    localStorage.setItem("username","");
}