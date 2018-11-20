$("#inMe").load("storeProduct-search.html")
setTimeout(hahahahaha, 1000);
function hahahahaha() {
    var home = {
        r1: $("#inr1"),
        r2: $("#inr2"),
        r3: $("#inr3")
    }
    var drow = [];
    var text = ""

    function drawR1(x, y, d, r) {
        text = `
        <div class="r1" data-who="` + d + `1"></div>
    `
        home.r1.append(text)
        $("[data-who='" + d + "1']").css("left", (x - 5 * r) + "px").css("top", (y - 5 * r) + "px").css("opacity", 0.33 * r).css("min-width", (10 * r) + "px").css("min-height", (10 * r) + "px")
        drow[d - 1] = [d, x, y, 1]
    }

    function drawR2(x, y, d, r) {
        text = `
        <div class="r2" data-who="` + d + `2"></div>
    `
        home.r2.append(text)
        $("[data-who='" + d + "2']").css("left", (x - 10 * r) + "px").css("top", (y - 10 * r) + "px").css("opacity", 0.2 * r).css("min-width", (20 * r) + "px").css("min-height", (20 * r) + "px")
        drow[d - 1] = [d, x, y, 1]
    }

    function drawR3(x, y, d, r) {
        text = `
        <div class="r3" data-who="` + d + `3"></div>
    `
        home.r3.append(text)
        $("[data-who='" + d + "3']").css("left", (x - 15 * r) + "px").css("top", (y - 15 * r) + "px").css("opacity", 0.125 * r).css("min-width", (30 * r) + "px").css("min-height", (30 * r) + "px")
        //        $("[data-who='" + d + "3']").text(d)
        drow[d - 1] = [d, x, y, 1]
    }

    //    function drawR11(x, y, d) {
    //        text = `
    //        <div class="r11" data-who="` + d + `11"></div>
    //    `
    //        home.r1.append(text)
    //        $("[data-who='" + d + "11']").css("left", (x - 10) + "px").css("top", (y - 10) + "px")
    //        drow[d - 1] = [d, x, y, 1]
    //    }
    //
    //    function drawR22(x, y, d) {
    //        text = `
    //        <div class="r22" data-who="` + d + `22"></div>
    //    `
    //        home.r2.append(text)
    //        $("[data-who='" + d + "22']").css("left", (x - 20) + "px").css("top", (y - 20) + "px")
    //        drow[d - 1] = [d, x, y, 1]
    //    }
    //
    //    function drawR33(x, y, d) {
    //        text = `
    //        <div class="r33" data-who="` + d + `33"></div>
    //    `
    //        home.r3.append(text)
    //        $("[data-who='" + d + "33']").css("left", (x - 30) + "px").css("top", (y - 30) + "px")
    //        drow[d - 1] = [d, x, y, 1]
    //    }

    // function drawChild(x, y, d, a, b, c) {
    //     circle.x = (x + a) / 2
    //     circle.y = (y + b) / 2
    //     if (Math.sqrt((x - a) * (x - a) + (y - b) * (y - b)) < 100) {
    //         drawR11(circle.x, circle.y)
    //     }
    //     if (Math.sqrt((x - a) * (x - a) + (y - b) * (y - b)) < 400) {
    //         drawR22(circle.x, circle.y)
    //     }
    //     if (Math.sqrt((x - a) * (x - a) + (y - b) * (y - b)) < 900) {
    //         drawR33(circle.x, circle.y)
    //     }
    // }

    function drawFirst(x, y, d, r) {
        drawR1(x, y, d, r);
        drawR2(x, y, d, r);
        drawR3(x, y, d, r);
    }

    //ajax

    $.ajax({
        type: "POST",
        url: "/TeamWork/Manager.getHotpoint",
        success: function (response) {
            console.log(response)
            response.forEach(xy => {
                drawFirst(xy.xy_x * 0.94, xy.xy_y * 0.94, xy.xy_id, xy.xy_r)
            });
        }
    });
}