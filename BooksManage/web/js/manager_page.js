function to_books(){
    window.open('manager_bookList.html','_blank');//跳转图书列表
}
function to_User(){
    window.open("manager_userList.html",'_blank');//跳转用户列表
}
function to_addUser(){
    window.open("manager_addUser.html",'_blank');//跳转添加用户
}

/*------------------------------图片轮播-----------------*/
//图片轮播
var p_index=0;
ps =  ["../image/xmu1.jpg","../image/xmu2.jpg","../image/xmu3.jpg","../image/xmu4.jpg","../image/xmu5.jpg"];
function showsp(){
    document.getElementById("pg1").src=ps[p_index];
    p_index++;
    if(p_index>=ps.length){
        p_index=0;
    }
}
setInterval(showsp,2000)

//--------------------------当前必是管理员
window.onload  =function (){
    const managername = localStorage.getItem("xzx_name");
    const user_info = document.getElementById("user_info");

    user_info.innerText = managername+",你好!";
}
