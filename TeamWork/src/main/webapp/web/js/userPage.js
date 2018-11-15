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







//會員中心的slidebar使用者的預設照片處理
function defaultUserPic(imgPath){
    if(imgPath==""){
        imgPath = "../images/user/account/profile/001.png"
    }
    return imgPath
}

//下載Member資料
function loadMemberData(userID) {
    $.ajax({
        url: "/TeamWork/Member?m_id=" + userID,
        error: function () {
            console.log("載入Member資料失敗")
        },
        success: function (res) {
            console.log("載入Member資料")
            memberData = res
            updateMemberData(memberData)
        }
    })
}

//更新會員中心slidebar資料
function updateMemberData(memberData) {
    $("#member_username").text(memberData.m_name);
    $("#member_coin").text(memberData.m_coin);
    $("#member_pic").attr("src", defaultUserPic(memberData.m_photo));
}