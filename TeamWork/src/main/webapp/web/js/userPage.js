function dateFormat(longDate) {
    var date = new Date(1398250549490);
    Y = date.getFullYear() + '-';
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    D = date.getDate() + ' ';
    return (Y + M + D);
}

$(".userpage-sidebar-menu_item-head").click(function () {
    var selector = $(this).attr("id");
    if ($("." + selector).css("display") == "none") {
        $("." + selector).css("display", "flex");
    } else {
        $("." + selector).css("display", "none");
    }
});

function replaceRN(text){
    // return text.replace(/\r\n/g, "<br/>");
    return text.replace("\r\n", "<br/>");
}