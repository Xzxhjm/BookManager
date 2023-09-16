function to_B_books(){
    window.open('user_bookList.html','_blank');//跳转借书
}
function to_R_Books(){
    window.open("user_borrowRecord.html",'_blank');//跳转还书
}
function to_search(){
    window.open("user_bookList.html",'_blank');//跳转搜索
}

/*------------------------------图片轮播-----------------*/
//图片轮播
var p_index=0;
ps =  ["image/xmu1.jpg","image/xmu2.jpg","image/xmu3.jpg","image/xmu4.jpg","image/xmu5.jpg"];
function showsp(){
    document.getElementById("pg1").src=ps[p_index];
    p_index++;
    if(p_index>=ps.length){
        p_index=0;
    }
}
setInterval(showsp,2000)


//--------------------------当前必是用户
window.onload  =function (){
    const username = localStorage.getItem("xzx_name");
    const user_info = document.getElementById("user_info");

    user_info.innerText = username+",你好!";
}
