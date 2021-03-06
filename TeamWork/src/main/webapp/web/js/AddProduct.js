//一鍵帶入=============
function wishonebringin(){
    $("[name='Wishlabel']").val("誠心 求:蘑菇 一百年份")
    $("[name='WishContext']").val("各種顏色都可以接受")
    $("[name='enddate']").val("2018-12-01")
    $("[name='WishName']").val("香菇一百年份")
    $("[name='WishAmount']").val("5")
    $("[name='WishPriceBottom']").val("10000")
    $("[name='WishPriceTop']").val("30000")
}
function storeonebringin(){
    $("[name='StoreProductName']").val("蘑菇 十年份 黑")
    $("[name='StoreProductContext']").val(
    `基本配件內容：
    (1)會動
    (2)馬力歐獨家技術 熟成十年份
    ■ 戴森第四代數位馬達 
    ■ 雙層氣旋 
    ■ 搭載dyson ballTM球型科技 
    ■ 全新軟質碳纖維滾筒吸頭 
    ■ 美國哮喘和過敏基金會(AAFA)及瑞士過敏協會 (Allergie Suisse)認證 
    ■ 五年保固`)
    $("[name='StoreProductAmount']").val("50")
    $("[name='StoreProductPrice']").val("29500")
    
}
//=====================================
$('#StoreModalCenter').modal('hide')
$('#GrouponModalCenter').modal('hide')
$('#WishModalCenter').modal('hide')

$("#StoreModalCenter").on("hidden.bs.modal", function() {
    $("#storerebtn").click()
});
$("#GrouponModalCenter").on("hidden.bs.modal", function() {
    $("#grouprebtn").click()
});
$("#WishModalCenter").on("hidden.bs.modal", function() {
    $("#wishrebtn").click()
});
//=================================抓取地區=====================================
$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "/TeamWork/changeDistFormSelect",
        // data: { "p_id": addProductSort },
        success: function (jsonback) {
            console.log("Dist")
            console.log(jsonback)
            var txtselect = "";
            txtselect += "<option value=0>--請選擇--</option>";

            for (x = 0; x < jsonback.length; x++) {
                txtselect += "<option value=" + jsonback[x].d_id + ">"
                    + jsonback[x].d_name
                    + "</option>";
            }
            $("[name='addarea']").html(txtselect);
        }
    });

    $.date = function(dateObject) {
        var d = new Date(dateObject);
        var day = d.getDate();
        var month = d.getMonth() + 1;
        var year = d.getFullYear();
        if (day < 10) {
            day = "0" + day;
        }
        if (month < 10) {
            month = "0" + month;
        }
        // var date = day + "/" + month + "/" + year;
        var date = year + "-" + month + "-" + day;
        return date;
    };

    console.log($.date(new Date()));
    //抓今天日期修改參數
    $("[name='enddate']").attr("value",$.date(new Date())).attr("min",$.date(new Date()));
})
//===================圖片瀏覽======================
function imgPreview(fileDom) {
    var theEvent = arguments.callee.caller.arguments[0];
    var target = theEvent.target | event.target;
    var id = $(event.target).next().next().attr("id");

    // alert("img======="+document.getElementById("Storepreview"))
    // alert("img2======="+img)
    //判斷是否支援filereader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        // alert("判斷瀏覽器是否支援瀏覽功能");
    }
    //獲取file
    // alert(fileDom)
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否為image
    if (!imageType.test(file.type)) {
        alert("選擇圖片！");
        return;
    }
    //讀取成功
    reader.onload = function (e) {
        //獲取圖片
        //  var img = $(event.target).files[i]
        // for(i=0;i<$(event.target).files.length;i++){
        // var img = createElement("img");
        $("#" + id).attr("src", e.target.result);
        // };
        // var img = document.getElementById("Storepreview");

        //圖片路徑設置為讀取的圖片
    };
    reader.readAsDataURL(file);
}
//===================CookieToJson=======================
function cookieToJson() {
    //cookie分割並去掉所有空白字串
    let cookieArr = document.cookie.replace(/\s/g, "").split(";");
    let obj = {}
    cookieArr.forEach((i) => {
        let arr = i.split("=");
        obj[arr[0]] = arr[1];
    });
    return obj
}
//=================================抓取商品類型=====================================
$("[name = 'StoreProductSort1']").change(function () {
    var addProductSort = $("[name = 'StoreProductSort1']").val();
    // alert(addProductSort)
    $.ajax({
        type: "POST",
        url: "/TeamWork/changeStoreFormSelect",
        data: { "p_id": addProductSort },
        success: function (jsonback) {
            // alert("server傳回 = " + jsonback);
            var json = JSON.parse(jsonback);
            console.log(json)
            var txtselect = "";
            txtselect += "<option value=0>--請選擇--</option>";

            for (x = 0; x < json.length; x++) {
                txtselect += "<option value=" + json[x].p_id + ">"
                    + json[x].p_name
                    + "</option>";
            }
            $("[name='addSort']").html(txtselect);
        }
    });
});
//=================================抓取開團類型=====================================
$("[name = 'GrouponSort1']").change(function () {
    var addProductSort = $("[name = 'GrouponSort1']").val();
    // alert(addProductSort)
    $.ajax({
        type: "POST",
        url: "/TeamWork/changeStoreFormSelect",
        data: { "p_id": addProductSort },
        success: function (jsonback) {
            // alert("server傳回 = " + jsonback);
            var json = JSON.parse(jsonback);
            console.log(json)
            var txtselect = "";
            txtselect += "<option value=0>--請選擇--</option>";

            for (x = 0; x < json.length; x++) {
                txtselect += "<option value=" + json[x].p_id + ">"
                    + json[x].p_name
                    + "</option>";
            }
            $("[name='addSort']").html(txtselect);
        }
    });
});
//=================================抓取許願類型=====================================
$("[name = 'WishSort1']").change(function () {
    var addProductSort = $("[name = 'WishSort1']").val();
    // alert(addProductSort)
    $.ajax({
        type: "POST",
        url: "/TeamWork/changeStoreFormSelect",
        data: { "p_id": addProductSort },
        success: function (jsonback) {
            // alert("server傳回 = " + jsonback);
            var json = JSON.parse(jsonback);
            console.log(json)
            var txtselect = "";
            txtselect += "<option value=0>--請選擇--</option>";

            for (x = 0; x < json.length; x++) {
                txtselect += "<option value=" + json[x].p_id + ">"
                    + json[x].p_name
                    + "</option>";
            }
            $("[name='addSort']").html(txtselect);
        }
    });
});
//===========================cookie判斷有無賣家身份=======================
function VerifySeller() {
    var json = cookieToJson();
    var cookieAccount = json['email']
    // alert("判斷有無賣家抓帳號==========" + cookieAccount)
    $.ajax({
        type: "POST",
        url: "/TeamWork/accountVerifySeller",
        data: { "account": cookieAccount },
        async: false,
        success: function (response) {
            // alert("賣家ID==========" + response);
            //判斷是不是空值
            if (response == null || response == undefined || response == '') {
                console.log("驗證賣家失敗");
                window.location.href = "http://localhost:8080/TeamWork/web/view/userPage_sellerVerifyNoStore.html"
            } else {
                console.log("驗證賣家成功");
                result = true
            }
        },
        error: function (response) {
            console.log(response);
            console.log("驗證失敗");
        }
    })
    return result;
}
//===========================cookie判斷有無店家身份=======================
var storeid;
function VerifyStore() {
    var json = cookieToJson();
    var cookieAccount = json['email']
    // alert("判斷有無店家抓帳號==========" + cookieAccount)
    $.ajax({
        type: "POST",
        url: "/TeamWork/accountVerifyStore",
        data: { "account": cookieAccount },
        async: false,
        success: function (response) {
            // alert("店家ID==========" + response);
            //判斷是不是空值
            if (response == null || response == undefined || response == '') {
                // alert("驗證店家失敗");
                window.location.href = "http://localhost:8080/TeamWork/web/view/userPage_sellerVerify.html"
            } else {
                // alert("驗證店家成功");
                storeid = response;
                result = true;
            }
        },
        error: function (response) {
            console.log(response);
            console.log("驗證失敗");
        }
    })
    return result;
}
//============================新增開店商品//需要店家身份==========================
$("#StoreProductClick").click(function (e) {
    var StoreProductName = $("[name = 'StoreProductName']").val();
    var StoreProductContext = $("[name = 'StoreProductContext']").val();
    var StoreProductSort;
    var addStore = $("[name = 'addSort']").val();
    if (addStore == 0) {
        StoreProductSort = $("[name = 'StoreProductSort1']").val();
    } else {
        StoreProductSort = addStore;
    }
    // alert(StoreProductSort)
    var StoreProductAmount = $("[name = 'StoreProductAmount']").val();
    var StoreProductPrice = $("[name = 'StoreProductPrice']").val();
    var Transport = $("[id = 'Transport']").val();
    var isNew = $("[id = 'isNew']").val();
    if (isNew == "是否全新") {
        isNew = "true"
    }
    // alert("isNew====" + isNew)
    // alert("addStore====" + addStore)
    // alert("StoreProductSort====" + StoreProductSort)
    //上傳圖片變數
    e.preventDefault(); // 停止觸發submit
    // alert("upload");
    $("input[name='te']").val(StoreProductName);
    // alert("inputtext======" + $("input[name='te']").val())
    var formData = new FormData($("#StoremyForm")[0]); // 使用FormData包裝form表單來傳輸資料
    // alert("formData=========" + formData.getAll)

    // 開始判斷有無店家身份
    if (VerifyStore()) {
        // alert(storeid)
        $.ajax({
            type: "POST",
            url: "/TeamWork/AddStoreProduct",
            data: {
                "s_id": storeid,
                "sP_name": StoreProductName,
                "sP_context": StoreProductContext,
                "p_id": StoreProductSort,
                "sP_amount": StoreProductAmount,
                "sP_price": StoreProductPrice,
                "sP_transport": JSON.stringify(Transport),
                "sP_new": isNew
            },
            dataType: "json",
            success: function (response) {
                var jsons = JSON.stringify(response);
                // alert("MVC傳回 = " + jsons);
                // console.log("MVC傳回 = " + jsons.get(0))
                // alert("SSSS");
                //上傳圖片
                $.ajax({
                    type: "POST",
                    url: "/TeamWork/uploadmutipart",
                    data: formData,
                    cache: false, // 不需要cache
                    processData: false, // jQuery預設會把data轉為query String, 所以要停用
                    contentType: false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
                    dataType: 'text',
                    success: function (data) {
                        // alert("upload sucess");
                    }
                });
                // $("").click()
                // $("").click()
                // window.location.href=""

            },
            error: function (response) {
                // var jsons = JSON.stringify(response);
                // alert("MVC傳回 = " + jsons);
                // alert("GG");
            }
        })
    }
})
//===========================新增開團商品//需要賣家身份===============================
$("#GrouponClick").click(function (e) {
    var GrouponName = $("[name = 'GrouponName']").val();
    var GrouponContext = $("[name = 'GrouponContext']").val();
    var GrouponSort = $("[name = 'GrouponSort1']").val();
    var GrouponAmount = $("[name = 'GrouponAmount']").val();
    var GrouponPrice = $("[name = 'GrouponPrice']").val();
    var GrouponVersion = $("[name = 'GrouponVersion']").val();

    //上傳圖片變數
    e.preventDefault(); // 停止觸發submit
    // alert("upload");
    $("input[name='te']").val(GrouponName);
    // alert("inputtext======" + $("input[name='te']").val())
    var formData = new FormData($("#GroupmyForm")[0]); // 使用FormData包裝form表單來傳輸資料
    // alert("formData=========" + formData.getAll)
    //判斷賣家
    if (VerifySeller()) {
        $.ajax({
            type: "POST",
            url: "/TeamWork/AddGroupon",
            data: {
                "gP_name": GrouponName,
                "gP_context": GrouponContext,
                "p_id": GrouponSort,
                "gP_amount": GrouponAmount,
                "gP_price": GrouponPrice,
                "gP_version": GrouponVersion
            },
            dataType: "json",
            success: function (response) {
                // console.log("MVC傳回 = " + jsons.get(0))
                // alert("MVC傳回 = " + response);
                var jsons = JSON.stringify(response);
                // alert("MVC傳回 = " + jsons);
                // console.log("MVC傳回 = " + response.get(0))
                // alert("SSSS");
                //上傳圖片修改為開團
                $.ajax({
                    type: "POST",
                    url: "/TeamWork/uploadmutipart",
                    data: formData,
                    cache: false, // 不需要cache
                    processData: false, // jQuery預設會把data轉為query String, 所以要停用
                    contentType: false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
                    dataType: 'text',
                    success: function (data) {
                        // alert("upload sucess");
                    }
                });
                // window.location.href=""

            },
            error: function (response) {
                // console.log("MVC傳回 = " + jsons.get(0))
                // var jsons = JSON.stringify(response);
                // alert("MVC傳回 = " + jsons);
                // console.log("MVC傳回 = " + response.get(0))
                // alert("GG");
            }
        })
    }
})
//===========================新增許願商品===============================
$("#WishClick").click(function (e) {
    var json = cookieToJson();
    var cookiemid = json['mid']
    var wishlabel = $("[name = 'Wishlabel']").val();
    var WishContext = $("[name = 'WishContext']").val();
    var addarea = $("[name = 'addarea']").val();
    var enddate = $("[name = 'enddate']").val();
    var WishName = $("[name = 'WishName']").val();
    var addStore = $("#addWishSort").val();
    var WishSort;
    if (addStore == 0) {
        WishSort = $("[name = 'WishSort1']").val();
    } else {
        WishSort = addStore;
    }
    // alert(WishSort)
    var WishSort = $("[name = 'WishSort1']").val();
    var WishAmount = $("[name = 'WishAmount']").val();
    var WishPriceBottom = $("[name = 'WishPriceBottom']").val();
    var WishPriceTop = $("[name = 'WishPriceTop']").val();
    //改好的值用json字串給伺服器
    var wishcombie = {
        "m_id": cookiemid, "p_id": WishSort, "w_title": wishlabel, "w_context": WishContext,
        "d_id": addarea, "w_endDate": enddate, "wP_name": WishName, "p_id": WishSort, "wP_amount": WishAmount,
        "wP_priceBottom": WishPriceBottom, "wP_priceTop": WishPriceTop
    };
    //原本combie是json物件 利用以下方法翻成json字串 ; 
    var wishjson = JSON.stringify(wishcombie);
    console.log("=======================================")
    console.log(wishjson)

    //上傳圖片變數
    e.preventDefault(); // 停止觸發submit
    // alert("upload");
    $("#wishpic").val(WishName);
    // alert("inputtext======" + $("#wishpic").val())
    var formData = new FormData($("#WishmyForm")[0]); // 使用FormData包裝form表單來傳輸資料
    // alert("formData=========" + formData.getAll)

    $.ajax({
        type: "POST",
        url: "/TeamWork/AddWishandProduct",
        data: wishjson,
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            console.log(response)
            // alert("SSSS");
            $.ajax({
                type: "POST",
                url: "/TeamWork/uploadmutipart",
                data: formData,
                cache: false, // 不需要cache
                processData: false, // jQuery預設會把data轉為query String, 所以要停用
                contentType: false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
                dataType: 'text',
                success: function (data) {
                    // alert("upload sucess");
                }
            });

        },
        error: function (response) {
            // console.log("MVC傳回 = " + jsons.get(0))
            // alert("MVC傳回 = " + response);
            // var jsons = JSON.stringify(response);
            // alert("MVC傳回 = " + jsons);
            // console.log("MVC傳回 = " + response.get(0))
            // alert("GG");
        }
    })
})