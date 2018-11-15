// =========jquery的include
$(document).ready(function () {
    console.log("看看有沒有跑INCLUDE")
    $.get("header.html", function (data) {
        $("#header").html(data);
    });
})