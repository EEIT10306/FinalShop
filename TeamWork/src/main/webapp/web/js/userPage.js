//日期格式Long 轉 YY-MM-DD
function dateFormat(longDate) {
    var date = new Date(1398250549490);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    return (Y + M + D);
}

//userPage左方選單伸縮
$(".userpage-sidebar-menu_item-head").click(function () {
    var selector = $(this).attr("id");
    if ($("." + selector).css("display") == "none") {
        $("." + selector).css("display", "flex");
    } else {
        $("." + selector).css("display", "none");
    }
});


//JSON 換行問題，先不處理，覺得換行不好看
function replaceRN(text) {
    // return text.replace(/\r\n/g, "<br/>");
    return text.replace("\r\n", "<br/>");
}

//評價表單的星星特效
$(".AssessStar").click(function () {
    $(".AssessStar").removeClass("fas").addClass("far");
    var starCount = $(this).attr("id").substr(-1);

    for (i = 1; i <= starCount; i++) {
        $("#forStar" + i).removeClass("far").addClass("fas");
    }
});