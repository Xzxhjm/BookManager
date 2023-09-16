//图片轮播
var p_index=0;
ps =  ["../image/xmu6.jpg","../image/xmu7.jpg","../image/xmu9.jpg","../image/xmu3.jpg","../image/xmu5.jpg"];
function showsp(){
    document.getElementById("pg1").src=ps[p_index];
    p_index++;
    if(p_index>=ps.length){
        p_index=0;
    }
}
setInterval(showsp,2000)

//------------上传反馈
function submit(){
    var fb_info = document.getElementById("input1").value;//用户反馈数据
    if(!fb_info){
        alert("您输入不能能为空！");
    }else{
        alert("感谢您的反馈!");
    }
}