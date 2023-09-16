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

