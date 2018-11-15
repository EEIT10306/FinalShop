//field
var wp = 3;
var gp = 3;
var sp = 3;

var where = "Wish";
var now = 1;
var state = "Processing"; //Processing Transaction Overrule
var page = 0;
var showCount = 7;
var hahaha = "";

let Page = {
    Wish: {
        P: [],
        T: [],
        O: [],
        pl: 0,
        tl: 0,
        ol: 0
    },
    Group: {
        P: [],
        T: [],
        O: [],
        pl: 0,
        tl: 0,
        ol: 0
    },
    StoreProduct: {
        P: [],
        T: [],
        O: [],
        pl: 0,
        tl: 0,
        ol: 0
    }
}

//function
function setBox(wheres, states, box) {
    whereName = "";
    if (wheres == "Wish") {
        whereName = "許願標題"
    } else if (wheres == "Group") {
        whereName = "開團名稱"
    } else {
        whereName = "商店標題"
    }
    page = Math.ceil(box.length / showCount)
    table = "";

    for (var i = 1; i <= page; i++) {
        if (i == 1) {
            table += "<div id='" + wheres + states + "'>"
        }
        table += `
        <table class="table table-bordered table-striped hidden" data-list="`+ wheres + states + i + `">
            <thead>
                <tr>
                <th>NO.</th>
                <th>`+ whereName + `</th>
                <th>被檢舉人</th>
                <th>檢舉人</th>
                <th>檢舉原因</th>
                `
        if (states == "Processing") {
            table += `
                <th>檢舉時間</th>
                `
        } else {
            table += `
                <th>單據處理時間</th>
            `
        }

        table += `
                <th>審核</th>
                </tr>
            </thead>
            <tbody>
        `
        if (wheres == "Wish") {
            if (i < page) {
                for (var j = (i - 1) * showCount; j < i * showCount; j++) {
                    getTime = new Date(box[j].wR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].wR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].w_id + `">Show</span>` + box[j].wish.w_title + `</td>
                    <td>` + box[j].wish.member.m_id + ` ` + box[j].wish.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].wR_content + `</td>
                    <td class="tdtime">` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].wR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].wR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            } else {
                for (var j = (i - 1) * showCount; j < box.length; j++) {
                    getTime = new Date(box[j].wR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].wR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].w_id + `">Show</span>` + box[j].wish.w_title + `</td>
                    <td>` + box[j].wish.member.m_id + ` ` + box[j].wish.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].wR_content + `</td>
                    <td>` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].wR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].wR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            }
        } else if (wheres == "Group") {
            if (i < page) {
                for (var j = (i - 1) * showCount; j < i * showCount; j++) {
                    getTime = new Date(box[j].gR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].gR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].g_id + `">Show</span>` + box[j].groupon.g_title + `</td>
                    <td>` + box[j].groupon.seller.member.m_id + ` ` + box[j].groupon.seller.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].gR_content + `</td>
                    <td>` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].gR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].gR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            } else {
                for (var j = (i - 1) * showCount; j < box.length; j++) {
                    getTime = new Date(box[j].gR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].gR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].g_id + `">Show</span>` + box[j].groupon.g_title + `</td>
                    <td>` + box[j].groupon.seller.member.m_id + ` ` + box[j].groupon.seller.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].gR_content + `</td>
                    <td>` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].gR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].gR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            }
        } else {
            if (i < page) {
                for (var j = (i - 1) * showCount; j < i * showCount; j++) {
                    getTime = new Date(box[j].sR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].sR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].sP_id + `">Show</span>` + box[j].storeProduct.sP_name + `</td>
                    <td>` + box[j].storeProduct.store.seller.member.m_id + ` ` + box[j].storeProduct.store.seller.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].sR_content + `</td>
                    <td>` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].sR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].sR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            } else {
                for (var j = (i - 1) * showCount; j < box.length; j++) {
                    getTime = new Date(box[j].sR_time)
                    showYear = 1900 + getTime.getYear()
                    showMonth = (1 + getTime.getMonth() < 10) ? "0" + (1 + getTime.getMonth()) : (1 + getTime.getMonth())
                    showDate = (getTime.getDate() < 10) ? "0" + (getTime.getDate()) : (getTime.getDate())
                    showHours = (getTime.getHours() < 10) ? "0" + (getTime.getHours()) : (getTime.getHours())
                    showMinutes = (getTime.getMinutes() < 10) ? "0" + (getTime.getMinutes()) : (getTime.getMinutes())
                    showSeconds = (getTime.getSeconds() < 10) ? "0" + (getTime.getSeconds()) : (getTime.getSeconds())
                    showTime = showYear + "/" + showMonth + "/" + showDate + " " + showHours + ":" + showMinutes + ":" + showSeconds

                    table += `
                    <tr>
                    <th scope="row">` + box[j].sR_id + `</th>
                    <td><span class="btn btn-info btn-sm" data-toggle="modal" data-target=".bd-example-modal-lg" data-open="` + wheres + "_" + box[j].sP_id + `">Show</span>` + box[j].storeProduct.sP_name + `</td>
                    <td>` + box[j].storeProduct.store.seller.member.m_id + ` ` + box[j].storeProduct.store.seller.member.m_name + `</td>
                    <td>` + box[j].member.m_id + ` ` + box[j].member.m_name + `</td>
                    <td>` + box[j].sR_content + `</td>
                    <td>` + showTime + `</td>`

                    if (states == "Processing") {
                        table += `
                        <td class="changeState" style="cursor:pointer">
                            <ul>
                                <li><span>` + box[j].state.state_context + `</span>
                                    <ul>
                                        <li><span data-state="` + wheres + "_" + box[j].sR_id + "_" + (box[j].state.state_id + 1) + `">通過</span></li>
                                        <li><span data-state="` + wheres + "_" + box[j].sR_id + "_" + (box[j].state.state_id + 2) + `">駁回</span></li>
                                    </ul>
                                </li>
                            </ul>
                        </td>
                        </tr>
                        `
                    } else {
                        table += `
                        <td>` + box[j].state.state_context + `</td>
                        </tr>
                        `
                    }
                }
            }
        }
        table += `
            </tbody>
        </table>
        `
        if (i == page) {
            table += "</div>"
        }
    }
    $(".requisition-box").append(table)
}

function setPage(wheres, states, box) {
    page = Math.ceil(box.length / showCount);
    pagetext = "";

    if (page > 0) {
        pagetext += `
        <nav aria-label="Page navigation example" class="page hidden" data-list="` + wheres + states + `">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled" data-page="1">
                    <div class="page-link">Previous</div>
                </li>
                <div>
                    <ul class="pagination justify-content-center">
                        <li class="page-item disabled" data-page="1">
                            <div class="page-link">1</div>
                        </li>
        `
        if (page > 1) {
            for (var i = 2; i <= page; i++) {
                pagetext += `
                        <li class="page-item" data-page="` + i + `">
                            <div class="page-link">` + i + `</div>
                        </li>
                `
            }
        }
        if (page > 1) {
            pagetext += `
                    </ul>
                </div>
                <li id="next" class="page-item" data-page="` + page + `">
                    <div class="page-link">Next</div>
                </li>
            </ul>
        </nav>
        `
        } else {
            pagetext += `
                    </ul>
                </div>
                <li id="next" class="page-item disabled" data-page="` + page + `">
                    <div class="page-link">Next</div>
                </li>
            </ul>
        </nav>
        `
        }
        $('#page-box').append(pagetext)
    }
}

//ajax
$.ajax({
    type: "POST",
    url: "/TeamWork/Manager.getReport",
    success: function (response) {
        Page.Wish.P = response.Wish[0]
        Page.Wish.T = response.Wish[1]
        Page.Wish.O = response.Wish[2]
        Page.Group.P = response.Group[0]
        Page.Group.T = response.Group[1]
        Page.Group.O = response.Group[2]
        Page.StoreProduct.P = response.StoreProduct[0]
        Page.StoreProduct.T = response.StoreProduct[1]
        Page.StoreProduct.O = response.StoreProduct[2]
        Page.Wish.pl = Page.Wish.P.length
        Page.Wish.tl = Page.Wish.T.length
        Page.Wish.ol = Page.Wish.O.length
        Page.Group.pl = Page.Group.P.length
        Page.Group.tl = Page.Group.T.length
        Page.Group.ol = Page.Group.O.length
        Page.StoreProduct.pl = Page.StoreProduct.P.length
        Page.StoreProduct.tl = Page.StoreProduct.T.length
        Page.StoreProduct.ol = Page.StoreProduct.O.length
        console.log(response)
        setBox("Wish", "Processing", Page.Wish.P)
        setBox("Wish", "Transaction", Page.Wish.T)
        setBox("Wish", "Overrule", Page.Wish.O)
        setBox("Group", "Processing", Page.Group.P)
        setBox("Group", "Transaction", Page.Group.T)
        setBox("Group", "Overrule", Page.Group.O)
        setBox("StoreProduct", "Processing", Page.StoreProduct.P)
        setBox("StoreProduct", "Transaction", Page.StoreProduct.T)
        setBox("StoreProduct", "Overrule", Page.StoreProduct.O)
        setPage("Wish", "Processing", Page.Wish.P)
        setPage("Wish", "Transaction", Page.Wish.T)
        setPage("Wish", "Overrule", Page.Wish.O)
        setPage("Group", "Processing", Page.Group.P)
        setPage("Group", "Transaction", Page.Group.T)
        setPage("Group", "Overrule", Page.Group.O)
        setPage("StoreProduct", "Processing", Page.StoreProduct.P)
        setPage("StoreProduct", "Transaction", Page.StoreProduct.T)
        setPage("StoreProduct", "Overrule", Page.StoreProduct.O)
        callback();
    }
});

//callback

function callback() {
    $('[data-list="WishProcessing1"]').removeClass('hidden')
    $('[data-list="WishProcessing"]').removeClass('hidden')

    function resetShowTable() {
        $('table').each(function () {
            if (!$(this).hasClass('hidden')) {
                $(this).addClass('hidden')
            }
        })
        $('[data-list="' + where + state + '1"]').removeClass("hidden")
    }

    function resetState() {
        $('nav-link').each(function () {
            if ($(this).hasClass('disabled')) {
                $(this).removeClass('disabled')
            }
        })
        $('[data-state="' + where + state + '1"]').addClass("disabled")
    }

    function resetPage() {
        //隱藏
        $('.page').each(function () {
            if (!$(this).hasClass('hidden')) {
                $(this).addClass('hidden')
            }
        })
        //都可按
        $("li.page-item").each(function () {
            if ($(this).hasClass('disabled')) {
                $(this).removeClass('disabled')
            }
        })
        //目前顯示
        $('[data-list="' + where + state + '"]').removeClass("hidden")
        //不可案初始化
        $('[data-page="0"]').each(function () {
            $(this).addClass('disabled')
        })
        $('[data-page="1"]').each(function () {
            $(this).addClass('disabled')
        })
    }

    function changePage(thatText) {
        if (!$(event.target).hasClass('disabled')) {
            $('table').each(function () {
                if (!$(this).hasClass('hidden')) {
                    $(this).addClass('hidden')
                }
            })

            $("li.page-item").each(function () {
                if ($(this).hasClass('disabled')) {
                    $(this).removeClass('disabled')
                }
            })

            if (thatText == "Next") {
                now++
            } else if (thatText == "Previous") {
                now--
            } else {
                now = thatText;
            }

            $('[data-list="' + where + state + now + '"]').removeClass("hidden")

            $('[data-list="' + where + state + '"]').find('[data-page="' + now + '"]').addClass('disabled')
        }
    }

    //event
    //where 選擇
    $('div.Ptitle').click(function () {
        where = $(event.target).text()
        state = "Processing"
        now = 1
        resetShowTable()
        resetState()
        resetPage()
    })

    //state 選擇
    $('.nav-link').click(function () {
        state = $(event.target).attr("data-state")
        now = 1
        resetShowTable()
        resetState()
        resetPage()
    })

    //page 選擇
    $('.page-item').click(function () {
        var thatText = $(event.target).text()
        // resetShowTable(thatText)
        changePage(thatText)
    })

    //state 修改
    $('.changeState li li').click(function () {
        var wheres = $(this).children(0).attr("data-state").split("_")[0]
        var r_id = $(this).children(0).attr("data-state").split("_")[1]
        var st_id = $(this).children(0).attr("data-state").split("_")[2]
        var data = {}

        var inwhere;
        var innow;
        var instate = ""
        var inwhereNOnow = ""

        // alert(wheres + r_id + st_id)
        if (wheres == "Wish") {
            data = { wR_id: r_id, wR_stateId: st_id }
            if (st_id == 47) {
                Page.Wish.pl--
                Page.Wish.tl++
                innow = Math.ceil(Page.Wish.tl / showCount);
                inwhere = $("[data-list='WishTransaction" + innow + "']")
                instate = "成功"
                inwhereNOnow = "WishTransaction"
            } else if (st_id == 48) {
                Page.Wish.pl--
                Page.Wish.ol++
                innow = Math.ceil(Page.Wish.ol / showCount);
                inwhere = $("[data-list='WishOverrule" + innow + "']")
                instate = "駁回"
                inwhereNOnow = "WishOverrule"
            }
            whereName = "許願標題"
        } else if (wheres == "Group") {
            data = { gR_id: r_id, gR_stateId: st_id }
            if (st_id == 64) {
                Page.Group.pl--
                Page.Group.tl++
                innow = Math.ceil(Page.Group.tl / showCount);
                inwhere = $("[data-list='GroupTransaction" + innow + "']")
                instate = "成功"
                inwhereNOnow = "GroupTransaction"
            } else if (st_id == 65) {
                Page.Group.pl--
                Page.Group.ol++
                innow = Math.ceil(Page.Group.ol / showCount);
                inwhere = $("[data-list='GroupOverrule" + innow + "']")
                instate = "駁回"
                inwhereNOnow = "GroupOverrule"
            }
            whereName = "開團名稱"
        } else {
            data = { sR_id: r_id, sR_stateId: st_id }
            if (st_id == 26) {
                Page.StoreProduct.pl--
                Page.StoreProduct.tl++
                innow = Math.ceil(Page.StoreProduct.tl / showCount);
                inwhere = $("[data-list='StoreProductTransaction" + innow + "']")
                instate = "成功"
                inwhereNOnow = "StoreProductTransaction"
            } else if (st_id == 27) {
                Page.StoreProduct.pl--
                Page.StoreProduct.ol++
                innow = Math.ceil(Page.StoreProduct.ol / showCount);
                inwhere = $("[data-list='StoreProductOverrule" + innow + "']")
                instate = "駁回"
                inwhereNOnow = "StoreProductOverrule"
            }
            whereName = "商店標題"
        }
        // alert(data)

        var that = $(this).parent().parent().parent().parent().parent()
        $.ajax({
            type: "Post",
            url: "/TeamWork/Manager.updateReportState",
            data: data,
            success: function (response) {
                that.find("td:nth-child(6)").html(response)
                that.find("td:nth-child(7)").html(instate)
                that.find("td:nth-child(7)").css("background-color", "red")
                that.find("td:nth-child(7)").css("color", "white")
                if (inwhere.find("tbody").children().length == 0) {
                    $("#" + inwhereNOnow).append(`
                    <table class="table table-bordered table-striped hidden" data-list="` + inwhereNOnow + innow + `">
                        <thead>
                            <tr>
                            <th>NO.</th>
                            <th>` + whereName + `</th>
                            <th>被檢舉人</th>
                            <th>檢舉人</th>
                            <th>檢舉原因</th>                    
                            <th>單據處理時間</th>
                            <th>審核</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>`)
                    $("[data-list='" + inwhereNOnow + "']").find("#next").attr("data-page",innow)
                    $("[data-list='" + inwhereNOnow + "']").children().find("ul").append("<li  class='page-item newpage' data-page='" + innow +"'><div class='page-link'>" + innow +"</div></li>")
                }
                $("[data-list='" + inwhereNOnow + innow + "']").find("tbody").append(that)
            }
        });

        $('#newPage').click(function () {
            var thatText = $(event.target).text()
            // resetShowTable(thatText)
            changePage(thatText)
        })

        $('.newPage').click(function () {
            var thatText = $(event.target).text()
            // resetShowTable(thatText)
            changePage(thatText)
        })
    })

    //table link 連結
    // $('span.btn-sm').click(function () {
    //     st = $(event.target).attr("data-open").split("_")
    //     if (st[0] == "Wish") {
    //         // window.open("/TeamWork/web/view/product-detail.html?w_id=" + st[1])
    //     } else if (st[0] == "Group") {
    //         // window.open("/TeamWork/web/view/product-detail.html?g_id=" + st[1])
    //     } else {
    //         window.open("/TeamWork/web/view/product-detail.html?sP_id=" + st[1])
    //     }
    // })
    $('span.btn-sm').click(function () {
        var wheres = $(this).attr("data-open").split("_");
        if (wheres[0] == "Wish") {
            hahaha = "w_id=" + wheres[1]
        } else if (wheres[0] == "Group") {
            hahaha = "g_id=" + wheres[1]
        } else {
            hahaha = "sP_id=" + wheres[1]
        }
        $(".modal-content").text("")
        if (wheres[0] == "Wish") {
            // $(".modal-content").load("/TeamWork/web/view/.html",hahaha)
        } else if (wheres[0] == "Group") {
            // $(".modal-content").load("/TeamWork/web/view/.html",hahaha)
        } else {
            $(".modal-content").load("/TeamWork/web/view/product-detail.html", hahaha)
        }
        $(".modal-content").css("width", "140%")
    })
}