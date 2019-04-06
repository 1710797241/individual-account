$(function () {
    var lis = $(".pages ul li");
    for(var i = 0;i<lis.length;i++){
        if(i==2||i==4||i==6){
            lis[i].style.width="1px";
            lis[i].style.height="14px";
            lis[i].style.borderRight="1px solid #C9C9C9";
        }
    }



})