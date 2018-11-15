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
$(document).ready(function () {
    //定義要用到的網址
    // var userID = "1";
    // var dataurl = "/TeamWork/WishOrderList?m_id=" + userID;
    var storeuserData;
    var wishuserData;
    var groupuserData;
    var state = 16;

    loadData();
    function loadData() {
        var json = cookieToJson();
        console.log(json)
        var cookieAccount = json['email'];
        //下載資料
        //商店訂單
        $.ajax({
            type: "POST",
            url: "/TeamWork/ReadStoreOrderState",
            data: { "account": cookieAccount },
            error: function (response) {
                var jsons = JSON.stringify(response);
                alert("noticeMVC傳回失敗 = " + jsons);
            },
            async: false,
            success: function (response) {
                console.log("傳入使用者資料")
                storeuserData = response;
                console.log("商店")
                console.log(storeuserData)
                // 更新畫面中的元素
                updateData()
            }
        })
        //許願訂單
        $.ajax({
            type: "POST",
            url: "/TeamWork/ReadWishOrderState",
            data: { "account": cookieAccount },
            error: function (response) {
                var jsons = JSON.stringify(response);
                alert("noticeMVC傳回失敗 = " + jsons);
            },
            async: false,
            success: function (response) {
                console.log("傳入使用者資料")
                wishuserData = response;
                console.log("許願")
                console.log(wishuserData)
                // 更新畫面中的元素
                updateData()
            }
        })
        //開團訂單
        $.ajax({
            type: "POST",
            url: "/TeamWork/ReadGroupOrderState",
            data: { "account": cookieAccount },
            error: function (response) {
                var jsons = JSON.stringify(response);
                alert("noticeMVC傳回失敗 = " + jsons);
            },
            async: false,
            success: function (response) {
                console.log("傳入使用者資料")
                groupuserData = response;
                console.log("開團")
                console.log(groupuserData)
                // 更新畫面中的元素
                // updateData()
            }
        })
    }
    function updateData() {
        $(".container-wrapper").html("");
        //許願
        if (state == 16) {
            for (let k in wishuserData) {
                //完願中
                var itemElstate5 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">完願中</div>
                        <div class="noti-card-detail_text">會員 ${wishuserData[k].wish.member.m_name} 已完成付款</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //配送中
                var itemElstate6 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">已出貨</div>
                        <div class="noti-card-detail_text">${wishuserData[k].member.m_name} 已將你的訂單出貨</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //待收貨
                var itemElstate7 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已送達</div>
                        <div class="noti-card-detail_text">會員的訂單已送達，請 ${wishuserData[k].wish.member.m_name} 完成取貨，謝謝</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //完成
                var itemElstate8 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已完成</div>
                        <div class="noti-card-detail_text">會員 ${wishuserData[k].wish.member.m_name} 的 ${wishuserData[k].wish.product.p_name} 訂單已完成</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                if (wishuserData[k].wO_stateId == 38) {
                    $(".container-wrapper").append(itemElstate5)
                }
                if (wishuserData[k].wO_stateId == 39) {
                    $(".container-wrapper").append(itemElstate6)
                }
                if (wishuserData[k].wO_stateId == 40) {
                    $(".container-wrapper").append(itemElstate7)
                }
                if (wishuserData[k].wO_stateId == 41) {
                    $(".container-wrapper").append(itemElstate8)
                }
            };
        }
        //開團
        if (state == 17) {
            for (let k in groupuserData) {
                //待出貨
                var itemElstate9 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">待出貨</div>
                        <div class="noti-card-detail_text">會員 ${groupuserData[k].member.m_name} 已完成付款</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //配送中
                var itemElstate10 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">已出貨</div>
                        <div class="noti-card-detail_text">${groupuserData[k].member.m_name} 已將你的訂單透過 ${groupuserData[k].member.m_name} 出貨</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //待收貨
                var itemElstate11 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已送達</div>
                        <div class="noti-card-detail_text">會員的訂單已送達，請 ${groupuserData[k].member.m_name} 完成取貨，謝謝</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //完成
                var itemElstate12 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已完成</div>
                        <div class="noti-card-detail_text">會員 ${groupuserData[k].member.m_name} 的 ${groupuserData[k].member.m_name} 訂單已完成</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                if (groupuserData[k].gO_stateId == 55) {
                    $(".container-wrapper").append(itemElstate9)
                }
                if (groupuserData[k].gO_stateId == 56) {
                    $(".container-wrapper").append(itemElstate10)
                }
                if (groupuserData[k].gO_stateId == 57) {
                    $(".container-wrapper").append(itemElstate11)
                }
                if (groupuserData[k].gO_stateId == 58) {
                    $(".container-wrapper").append(itemElstate12)
                }
            };
        }
        //商店
        if (state == 18) {
            for (let k in storeuserData) {
                //待出貨
                var itemElstate1 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">待出貨</div>
                        <div class="noti-card-detail_text">會員 ${storeuserData[k].member.m_name} 已完成付款</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //配送中
                var itemElstate2 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">已出貨</div>
                        <div class="noti-card-detail_text">${storeuserData[k].storeProduct.store.s_name} 已將你的訂單透過 ${storeuserData[k].sO_transport} 出貨</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //待收貨
                var itemElstate3 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已送達</div>
                        <div class="noti-card-detail_text">會員的訂單已送達，請 ${storeuserData[k].member.m_name} 完成取貨，謝謝</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                //完成
                var itemElstate4 = $(`
                <div class="noti-card">
                    <div class="noti-card-img">
                        <img src="../images/user/noti/001.svg">
                    </div>
                    <div class="noti-card-detail">
                        <div class="noti-card-detail_title">商品已完成</div>
                        <div class="noti-card-detail_text">會員 ${storeuserData[k].member.m_name} 的 ${storeuserData[k].sO_pay} 訂單已完成</div>
                        <div class="noti-card-detail_date">31-10-2018 19:32</div>
                    </div>
                    <div class="btn btn-sm order_btn">詳細資訊</div>
                </div>
                `)
                if (storeuserData[k].sO_stateId == 16) {
                    $(".container-wrapper").append(itemElstate1)
                }
                if (storeuserData[k].sO_stateId == 17) {
                    $(".container-wrapper").append(itemElstate2)
                }
                if (storeuserData[k].sO_stateId == 18) {
                    $(".container-wrapper").append(itemElstate3)
                }
                if (storeuserData[k].sO_stateId == 19) {
                    $(".container-wrapper").append(itemElstate4)
                }
            };
        }


        //如果沒有東西可以顯示就顯示插圖
        if ($(".container-wrapper").html() == "") {
            initData();
        }
        //卡片click事件
        $(".hrefUrl").click(function () {
            var hrefUrl = "test.html"
            document.location.href = hrefUrl;
        });

        //給予評價按鈕click事件
        $(".StartAssessBtn").click(function () {
            var wO_id = $(this).attr("name");
            $("input#wO_id").val(wO_id);
        });

        //評價表單submit事件(AJAX)
        $("#giveAssess_form").on('submit', function () {
            console.log("評價表單submit")
            $.ajax({
                type: "POST",
                url: "/TeamWork/giveAssess_WishBuyer",
                data: $(this).serialize(),
                success: function () {
                    alert("success!!!");
                    $("#giveAssess").css("display", "none");
                    //關閉互動視窗
                    $("button.close").click();
                    $("#giveAssess_form").find(":text,textarea").each(function () {
                        //清空表單所有欄位
                        $(this).val("");
                    });
                }
            });
            return false; //阻止form submit
        });
        //確認收貨按鈕
        $(".confirmReceive").click(function () {
            console.log("確認收貨按鈕click")
            var wO_id = $(this).attr("id").replace("confirmReceive", "")
            console.log("wO_id=" + wO_id);
            $.ajax({
                type: "POST",
                url: "/TeamWork/confirmReceive_Wish",
                data: { "wO_id": wO_id },
                success: function () {
                    alert("success!");
                    loadData();
                }
            });

        });
    }
    function initData() {
        var emptyEl = $(`
                    <div class="empty">
                        <img src="../images/user/others/empty_order.svg">
                        <p>這裡什麼都沒有耶</p>
                        <p>要不要許些願望呢？</p>
                    </div>
                `)
        $(".container-wrapper").append(emptyEl);
    }
    $(".purchase-list-page_tab").click(function (e) {
        $(".tab_lock").removeClass("tab_lock");
        $(this).addClass("tab_lock");
        var changeState = $(this).text();
        switch (changeState) {
            case "許願通知":
                state = 16;
                break;
            case "開團通知":
                state = 17;
                break;
            case "商城通知":
                state = 18;
                break;
            default:
                state = 16;
        }
        updateData();
    });
});