//===================圖片瀏覽======================
function imgPreview(fileDom) {
    //判斷是否支援filereader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("判斷瀏覽器是否支援瀏覽功能");
    }
    //獲取file
    alert(fileDom)
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
        var img = document.getElementById("preview");
        //圖片路徑設置為讀取的圖片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
}
//===================CookieToJson=======================
function cookieToJson() {
    let cookieArr = document.cookie.split(";");
    let obj = {}
    cookieArr.forEach((i) => {
        let arr = i.split("=");
        obj[arr[0]] = arr[1];
    });
    return obj
}
//=================================抓取商品類型=====================================
$("[class='custom-select form-group']").change(function () {
    var addProductSort = $("[class='custom-select form-group']").val();
    $.ajax({
        type: "POST",
        url: "/TeamWork/changeStoreFormSelect",
        data: { "p_id": addProductSort },
        success: function (jsonback) {
            alert("server傳回 = " + jsonback);
            var json = JSON.parse(jsonback);
            var txtselect = "";
            txtselect += "<option value=0>--請選擇--</option>";

            for (x = 0; x < json.length; x++) {
                txtselect += "<option value=" + x + ">"
                    + json[x].p_name
                    + "</option>";
            }
            $("[name='addSort']").html(txtselect);
        }
    });
});
//===========================判斷有無賣家身份=======================
function VerifySeller() {
    var json = cookieToJson();
    var cookieAccount = json['email']
    console.log(cookieAccount)
    $.ajax({
        type: "POST",
        url: "/TeamWork/accountVerifySeller",
        data: { "account": cookieAccount },
        async: false,
        success: function (response) {
            alert("賣家ID==========" + response);
            //判斷是不是空值
            if (response == null || response == undefined || response == '') {
                alert("驗證賣家失敗");
                window.location.href = "http://localhost:8080/TeamWork/web/view/userPage_sellerVerify.html"
            } else{
                alert("驗證賣家成功");
                result = true
            }
            
        },
        error: function (response) {
            alert(3)
            alert(response);
            alert("驗證失敗");
        }
    })
    return result;
}
//============================新增開店商品//需要店家身份==========================
$("#StoreProductClick").click(function (e) {
    var StoreProductName = $("[name = 'StoreProductName']").val();
    var StoreProductContext = $("[name = 'StoreProductContext']").val();
    var StoreProductSort = $("[name = 'StoreProductSort1']").val();
    var StoreProductAmount = $("[name = 'StoreProductAmount']").val();
    var StoreProductPrice = $("[name = 'StoreProductPrice']").val();
    var Transport = $("[id = 'Transport']").val();
    var isNew = $("[id = 'isNew']").val();
    if (isNew == "是否全新") {
        isNew = "true"
    }
    alert("isNew====" + isNew)
    //上傳圖片變數
    e.preventDefault(); // 停止觸發submit
    alert("upload");
    $("input[name='te']").val(StoreProductName);
    alert("inputtext======" + $("input[name='te']").val())
    var formData = new FormData($("#myForm")[0]); // 使用FormData包裝form表單來傳輸資料
    alert("formData=========" + formData.getAll)

    // 開始判斷有無店家身份
    if (VerifySeller()) {
        $.ajax({
            type: "POST",
            url: "/TeamWork/AddStoreProduct",
            data: {
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
                alert("MVC傳回 = " + jsons);
                // console.log("MVC傳回 = " + jsons.get(0))
                alert("SSSS");
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
                        alert("upload sucess");
                    }
                });
                // window.location.href=""

            },
            error: function (response) {
                var jsons = JSON.stringify(response);
                alert("MVC傳回 = " + jsons);
                // console.log("MVC傳回 = " + jsons.get(0))
                alert("GG");
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
    var GrouponImagesUpload = $("[id = 'GrouponImagesUpload']").val();
    var combie = {
        "gP_name": GrouponName,
        "gP_context": GrouponContext,
        "p_id": GrouponSort,
        "gP_amount": GrouponAmount,
        "gP_price": GrouponPrice,
        "gP_version": GrouponVersion
    };
    console.log(combie);
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
            alert("MVC傳回 = " + response);
            var jsons = JSON.stringify(response);
            alert("MVC傳回 = " + jsons);
            // console.log("MVC傳回 = " + response.get(0))
            alert("SSSS");

        },
        error: function (response) {
            // console.log("MVC傳回 = " + jsons.get(0))
            alert("MVC傳回 = " + response);
            var jsons = JSON.stringify(response);
            alert("MVC傳回 = " + response);
            // console.log("MVC傳回 = " + response.get(0))
            alert("GG");
        }
    })
})
//===========================新增許願商品===============================
$("#WishClick").click(function (e) {
    var WishName = $("[name = 'WishName']").val();
    var WishSort = $("[name = 'WishSort1']").val();
    var WishAmount = $("[name = 'WishAmount']").val();
    var WishPriceBottom = $("[name = 'WishPriceBottom']").val();
    var WishPriceTop = $("[name = 'WishPriceTop']").val();
    var WishImagesUpload = $("[id = 'WishImagesUpload']").val();

    var combie = {
        "wP_name": WishName,
        "p_id": WishSort,
        "wP_amount": WishAmount,
        "wP_priceBottom": WishPriceBottom,
        "wP_priceTop": WishPriceTop
    };
    console.log(combie);
    $.ajax({
        type: "POST",
        url: "/TeamWork/AddWish",
        data: {
            "wP_name": WishName,
            "p_id": WishSort,
            "wP_amount": WishAmount,
            "wP_priceBottom": WishPriceBottom,
            "wP_priceTop": WishPriceTop
        },
        dataType: "json",
        success: function (response) {
            // console.log("MVC傳回 = " + jsons.get(0))
            alert("MVC傳回 = " + response);
            var jsons = JSON.stringify(response);
            alert("MVC傳回 = " + response);
            // console.log("MVC傳回 = " + response.get(0))
            alert("SSSS");

        },
        error: function (response) {
            // console.log("MVC傳回 = " + jsons.get(0))
            alert("MVC傳回 = " + response);
            var jsons = JSON.stringify(response);
            alert("MVC傳回 = " + response);
            // console.log("MVC傳回 = " + response.get(0))
            alert("GG");
        }
    })

})