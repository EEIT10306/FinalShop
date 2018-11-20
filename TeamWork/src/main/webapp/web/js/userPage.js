//日期格式Long 轉 YY-MM-DD
function dateFormat(longDate) {
    var date = new Date(1398250549490);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    return (Y + M + D);
}

// userPage左方選單伸縮
$(".userpage-sidebar-menu_item-head").click(function () {
    var selector = $(this).attr("id");
    if ($("." + selector).css("display") == "none") {
        $("." + selector).css("display", "flex");
    } else {
        $("." + selector).css("display", "none");
    }
});


// JSON 換行問題，先不處理，覺得換行不好看
function replaceRN(text) {
    // return text.replace(/\r\n/g, "<br/>");
    return text.replace("\r\n", "<br/>");
}

// 評價表單的星星特效
$(".AssessStar").click(function () {
    $(".AssessStar").removeClass("fas").addClass("far");
    var starCount = $(this).attr("id").substr(-1);

    for (i = 1; i <= starCount; i++) {
        $("#forStar" + i).removeClass("far").addClass("fas");
    }
});

// 會員中心的slidebar使用者的預設照片處理
function defaultUserPic(imgPath) {
    if (imgPath=="" || imgPath==null|| typeof(imgPath) == "undefined") {
        imgPath = "../images/user/account/profile/default.png"
    }
    return imgPath
}

// 會員中心的產品預設照片處理
function defaultProdPic(imgPath){
    if (imgPath=="" || imgPath==null || typeof(imgPath) == "undefined") {
        imgPath = "../images/product/default.jpeg"
    }
    return imgPath
}
// 下載Member資料
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

// 更新會員中心slidebar資料
function updateMemberData(memberData) {
    $("#member_username").text(memberData.m_name);
    $("#member_coin").text(memberData.m_coin);
    $("#member_pic").attr("src", defaultUserPic(memberData.m_photo));
    $("#seeProfile").attr("href","userPage_seeProfile.html?id="+memberData.m_id);
}


function cookieToJson_userPage() {
    // cookie分割並去掉所有空白字串
    let cookieArr = document.cookie.replace(/\s/g, "").split(";");
    let obj = {}
    cookieArr.forEach((i) => {
        let arr = i.split("=");
        obj[arr[0]] = arr[1];
    });
    return obj
}


// cookie判斷有無賣家身份
function VerifyCheckSeller(url) {
    var json = cookieToJson_userPage();
    var cookieAccount = json['email']
    console.log("判斷有無賣家抓帳號:" + cookieAccount)
    $.ajax({
        type: "POST",
        url: "/TeamWork/accountVerifySeller",
        data: { "account": cookieAccount },
        async: false,
        success: function (response) {
            console.log("賣家ID" + response);
            // 判斷是不是空值
            if (response == null || response == undefined || response == '') {
                console.log("驗證賣家失敗");
                swal({
                    title: '需要賣家身分驗證！',
                    text: '您尚未驗證成為賣家，即將前往驗證頁面',
                    type: 'warning',
                    confirmButtonText: '前往驗證',
                    confirmButtonColor: '#525abb'
                }).then(function () {
                    window.location.href = "userPage_sellerVerifyNoStore.html";
                })
            } else {
                console.log("驗證賣家成功");
                window.location.href = url
            }
        },
        error: function (response) {
            console.log(response);
            console.log("賣家驗證失敗");
        }
    })
}
// cookie判斷有無店家身份
var storeid;
var userEmail = '';
function VerifyCheckStore(url) {
    userEmail = document.cookie.split("email=")[1].split(";")[0]
    console.log("判斷有無店家抓帳號:" + userEmail)
    $.ajax({
        type: "POST",
        url: "/TeamWork/accountVerifyStore",
        data: { "account": userEmail },
        async: false,
        success: function (response) {
            console.log("店家ID" + response);
            // 判斷是不是空值
            if (response == null || response == undefined || response == '') {
                swal({
                    title: '需要店家身分驗證！',
                    text: '您尚未驗證成為店家，即將前往驗證頁面',
                    type: 'warning',
                    confirmButtonText: '前往驗證',
                    confirmButtonColor: '#525abb'
                }).then(function () {
                    window.location.href = "userPage_sellerVerify.html";
                })
            } else {
                console.log("驗證店家成功");
                storeid = response;
                window.location.href = url
            }
        },
        error: function (response) {
            console.log(response);
            console.log("店家驗證失敗");
        }
    })
}

//商品類別下拉選單
function LoadProdSelector() {
    $.ajax({
        url: "/TeamWork/ProdSelectorFirst",
        error: function () {
            console.log("載入商品類別第一層資料失敗")
        },
        success: function (res) {
            console.log("載入商品類別第一層資料成功")
            prodFirstData = res
            updateProdFirstData(prodFirstData)
        }
    })
}
//更新商品類別第一層選單選項
function updateProdFirstData(prodFirstData) {
    prodFirstData.forEach(function (item) {
        var itemEl = $(`<option value="${item.p_id}">${item.p_name}</option>`)
        $("#pp_id").append(itemEl);
    })
}
//商品類別第一層選單change事件
$("#pp_id").change(function() {
    var prodId1 = $("#pp_id").val();
    updateProdSecondtData(prodId1)
  });
//更新商品類別第二層選單選項
function updateProdSecondtData(prodId1) {
    $.ajax({
        url: "/TeamWork/ProdSelectorSecond?p_id="+prodId1,
        error: function () {
            console.log("載入商品類別第二層資料失敗")
        },
        success: function (res) {
            console.log("載入商品類別第二層資料成功")
            $("#p_id").html("");
            prodSecondData = res
            prodSecondData.forEach(function (item) {
                var itemEl = $(`<option value="${item.p_id}">${item.p_name}</option>`)
                $("#p_id").append(itemEl);
            })
        }
    })
    
}