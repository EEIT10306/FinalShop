$(document).ready(function () {
    getConversation();
})

var timeset;

function getConversation() {
    var conversationTalker;
    var conversationContext;
    var conversationDate;
    var conversationShowTime;
    var conversationId;
    var count = 0;
    $.ajax({
        type: "POST",
        url: "/TeamWork/Manager.getConversation",
        data: { m_id: 25 },
        success: function (response) {
            console.log(response)
            count = response.length;

            resetConversation();

            for (var x = 0; x < count; x++) {
                conversationTalker = (response[x][0].m_id == 25) ? response[x][0].memberConversation.m_name : response[x][0].member.m_name;// 最後發話人是此人嗎
                conversationContext = (response[x][0].c_context.length <= 8) ? response[x][0].c_context : response[x][0].c_context.substr(0, 8) + "...";
                conversationDate = new Date(response[x][0].c_time);
                conversationShowTime = (conversationDate.getMinutes() < 10) ? conversationDate.getHours() + ":0" + conversationDate.getMinutes() : conversationShowTime = conversationDate.getHours() + ":" + conversationDate.getMinutes();// 分之前是否要加0
                conversationId = (response[x][0].m_id == 25) ? response[x][0].memberConversation.m_id : response[x][0].member.m_id;
                conversationPhoto = (response[x][0].m_id == 25) ? response[x][0].memberConversation.m_photo : response[x][0].member.m_photo
                conversationShowPhoto = (conversationPhoto == "") ? "../images/user/account/profile/001.png" : conversationPhoto
                stateCount = 0;

                for (y in response[x]) {
                    if (response[x][y].m_id != 25) {
                        stateCount += (response[x][y].c_stateId == 3) ? 1 : 0;
                    }
                }

                showConversationTalker(stateCount, conversationId, conversationTalker, conversationContext, conversationShowTime, conversationShowPhoto);

                responseNow = response[x]
                showConversationContext(responseNow, conversationId);
            }

            chatjs();

            timer();
        }
    });
}

function resetConversation() {
    $("ul#conversation_page").html("");
    $("div#contextIn").html("");
}

function showConversationTalker(stateCount, conversationId, conversationTalker, conversationContext, conversationShowTime, conversationShowPhoto) {
    var showConversationTalker = "";
    showConversationTalker += `
        <li class="person" data-chat="person` + conversationId + `">`

    if (stateCount != 0) {
        showConversationTalker += `<div class="conversationLeftNoRead-active">` + stateCount + `</div>`
    } else {
        showConversationTalker += `<div class="conversationLeftNoRead-active isZero">` + stateCount + `</div>`
    }

    showConversationTalker += `
            <input type = "hidden" id="conversationId" value="` + conversationId + `">
            <img src="` + conversationShowPhoto + `" alt="" />
            <span class="name">` + conversationTalker + `</span>
            <span class="time">` + conversationShowTime + `</span>
            <span class="preview">` + conversationContext + `</span>
        </li>
    `
    $("ul#conversation_page").append(showConversationTalker);
}

function showConversationContext(responseNow, conversationId) {
    countContext = responseNow.length;
    var whatTime;
    var whatTimeLast;
    var showConversationContext = "";
    showConversationContext += '<div class="chat" data-chat="person' + conversationId + '">';
    for (var y = countContext - 1; y >= 0; y--) {
        allConversationDate = new Date(responseNow[y].c_time);
        youOrMe = (responseNow[y].m_id == 25) ? 'me' : 'you';
        youOrMeTime = (responseNow[y].m_id == 25) ? 'conversationBlockTimeRight' : 'conversationBlockTimeLeft';
        conversationTime = (allConversationDate.getMinutes() < 10) ? allConversationDate.getHours() + ':0' + allConversationDate.getMinutes() : allConversationDate.getHours() + ':' + allConversationDate.getMinutes();
        if (y != countContext) {
            whatTimeLast = whatTime;
        }
        whatTime = allConversationDate.getMonth() + 1 + '/' + allConversationDate.getDate();
        addTime = (whatTime == whatTimeLast) ? "" : `      
        	<div class="conversation-start"><span>` + whatTime + `</span></div>
        `;

        if (responseNow[y].c_stateId == 5) {
            showConversationContext += `
                <div class="conversationBlock">已收回</div>
                `
        } else {
            showConversationContext += addTime + `
          <div>
            <div class="bubble ` + youOrMe + `">` + responseNow[y].c_context + `</div>
            <span class="` + youOrMeTime + `">` + conversationTime + `</span>
           </div>
        `
        }
    }
    $("div#contextIn").append(showConversationContext)
}
/* searchConversation====================================================================================================== */
$(document).ready(function () {
    $("#searchMe").keyup(function (e) {
        if (e.keyCode == 13) {
            $("#searchMe").val("")
        };
        var value = $(this).val().toLowerCase();
        $(".person").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        })
    })
});
/* sendNewConversation====================================================================================================== */
function sendNewConversation() {
    var c_context = $("#sendMe").val();
    var m_idConversation = $(".active #conversationId").val();
    $("#sendMe").val("");
    $.ajax({
        type: "post",
        url: "/TeamWork/Manager.sendNewConversation",
        data: { m_id: 25, c_context: c_context, m_idConversation: m_idConversation },
        success: function (response) {
            var conversationTime = new Date(response.c_time);
            getTime = (conversationTime.getMinutes() < 10) ? conversationTime.getHours() + ':0' + conversationTime.getMinutes() : conversationTime.getHours() + ':' + conversationTime.getMinutes();
            showConversationContext = `
                <div>
                    <div class="bubble me">` + response.c_context + `</div>
                    <span class="conversationBlockTimeRight">` + getTime + `</span>
                </div>
            `;
            var responseTime = new Date()
            $("div.active-chat").append(showConversationContext)
            $(".active .time").html((responseTime.getMinutes() < 10) ? responseTime.getHours() + ":0" + responseTime.getMinutes() : responseTime.getHours() + ":" + responseTime.getMinutes())
            $(".active .preview").html((response.c_context.length <= 8) ? response.c_context : response.c_context.substr(0, 8) + "...")

            divBottom();
            changeChatList($('.active'));
        }
    });
}

function changeChatList(who) {
    $("#conversation_page").prepend(who);
}

function reading(who) {
    var m_id = who;
    $.ajax({
        type: "Post",
        url: "/TeamWork/Manager.changeConversationRead",
        data: { m_id: m_id, c_stateId: 4 },
        success: function (response) {
            if ($(".conversationLeftNoRead,.isZero") != null) {
                $(".conversationLeftNoRead").text("0")
                $(".conversationLeftNoRead").addClass("isZero")
            }
        }
    });
}

function timer() {
    timeset = setInterval(haveNewMessage, 3000);
    // clearInterval(timeset);
}

$("#sendMe").keyup(function (e) {
    if (e.keyCode == 13) {
        if ($(this).val() != "" && $(".active-chat").length != 0) {
            sendNewConversation();
            divBottom();
        } else {
            $("#sendMe").val("");
        }
    }
});

var lastData
var unfirst = false
function haveNewMessage() {
    $.ajax({
        type: "Post",
        url: "/TeamWork/Manager.haveNewMessage",
        success: function (response) {
            if (unfirst) {
                //是否有未讀訊息(有才做事)
                if (response != undefined && response != null) {
                    //原本是否未全已讀
                    if (lastData != undefined && lastData != null && lastData != "") {
                        // 是否有新訊息
                        if (JSON.stringify(response) != JSON.stringify(lastData)) {
                            for (let now of response) {
                                // 此人是否原有未讀(找)
                                var unRead = false;
                                for (let old of lastData) {
                                    // 如果找到原有
                                    if (now[0].m_id == old[0].m_id) {
                                        //此人是否有新訊息
                                        if (now[0].c_time > old[0].c_time) {
                                            var nowEachBox = [];
                                            for (let nowEach of now) {
                                                //此訊息是否原本就存在(找)
                                                var exist = false;
                                                for (let oldEach of old) {
                                                    // 如果找到存在
                                                    if (nowEach.c_id == oldEach.c_id) {
                                                        exist = true;
                                                        break;
                                                    }
                                                };
                                                //此訊息是新訊息
                                                if (!exist) {
                                                    nowEachBox.push(nowEach)
                                                }
                                            };
                                            if (nowEachBox != null) {
                                                alert(1)
                                                setUnReadMessage(nowEachBox, now.length);
                                            }
                                        }
                                        unRead = true;
                                        break;
                                    }
                                };
                                //此人之前未有未讀
                                if (!unRead) {
                                    alert(2)
                                    setUnReadMessage(now, now.length);
                                }
                            };
                        }
                        //原本全都已讀
                    } else {
                        for (let now of response) {
                            alert(3)
                            setUnReadMessage(now, now.length);
                        };
                    }
                }
                // console.log(lastData)
                // console.log(response)
            } else {
                unfirst = true
            }
            lastData = response
        }
    });
}

function setUnReadMessage(response, unread) {
    var count = $(".person").length
    var textLeft = ""
    var textRight = ""
    var responseTime = new Date(response[0].c_time)
    var timeRight
    var showTime = ""
    $.each($("li.person"), function () {
        if ($(this).find("#conversationId").val() == response[0].m_id) {
            //resetLeft
            if (!$(this).hasClass("active")) {
                if ($(this).find(".conversationLeftNoRead-active").text() == 0) {
                    $(this).find(".conversationLeftNoRead-active").removeClass("isZero")
                }
                $(this).find(".conversationLeftNoRead-active").text(unread)
            }
            $(this).find(".time").text((responseTime.getMinutes() < 10) ? responseTime.getHours() + ":0" + responseTime.getMinutes() : responseTime.getHours() + ":" + responseTime.getMinutes())
            $(this).find(".preview").text(response[0].c_context)
            // console.log(this)
            // console.log(response)
            //resetRight
            for (var i = response.length - 1; i >= 0; i--) {
                timeRight = new Date(response[i].c_time)
                showTime = (timeRight.getMinutes() < 10) ? timeRight.getHours() + ":0" + timeRight.getMinutes() : timeRight.getHours() + ":" + timeRight.getMinutes()
                textRight += `
                <div>
                    <div class="bubble you">` + response[i].c_context + `</div>
                    <span class="conversationBlockTimeLeft">` + showTime + `</span>
                </div>
                `
            }
            $(".chat[data-chat='person" + response[0].m_id + "']").append(textRight)
            // 其他重要更改
            changeChatList($(".people [data-chat='person" + response[0].m_id + "']"))
            divBottom();
            if ($(this).hasClass("active")) {
                reading(response[0].m_id);
            }
        } else {
            count--
        }
        if (count == 0) {
            var photo = (response[0].member.m_photo == "") ? "../images/user/account/profile/001.png" : response[0].member.m_photo
            //resetLeft
            textLeft = `
            <li class="person" data-chat="person` + response[0].m_id + `"><div class="conversationLeftNoRead-active">` + response.length + `</div>
                <input type="hidden" id="conversationId" value="` + response[0].m_id + `">
                <img src="` + photo + `" alt="">
                <span class="name">` + response[0].member.m_name + `</span>
                <span class="time">` + responseTime + `</span>
                <span class="preview">` + response[0].c_context + `</span>
            </li>
            `
            $("ul#conversation_page").prepent(textLeft)
            //resetRight
            $("div.top.name").html(response[0].member.m_name)
            dateRightShow = new Date(response[response.length - 1].c_time)
            showDate = dateRightShow.getMonth() + 1 + "/" + dateRightShow.getDate()
            textRight = `
            <div class="chat" data-chat="person` + response[0].m_id + `">
                <div class="conversation-start"><span>` + showDate + `</span></div>`
            for (j = response.length - 1; j >= 0; j--) {
                timeRightShow = new Date(response[j].c_time)
                showTime = (timeRightShow.getMinutes() < 10) ? timeRightShow.getHours() + ":0" + timeRightShow.getMinutes() : timeRightShow.getHours() + ":" + timeRightShow.getMinutes()
                textRight += `
                <div>
                    <div class="bubble you">` + response[j].c_context + `</div>
                    <span class="conversationBlockTimeLeft">` + showTime + `</span>
                </div>`
            }
            textRight += `</div>`
            $("div#contextIn").prepend(textRight)
            changeChatList($(".people [data-chat='person" + response[0].m_id + "']"))
            divBottom();
        }
    })
}


// /*chat======================================================================================================*/
// document.querySelector('.chat[data-chat=person1]').classList.add('active-chat')
// document.querySelector('.person[data-chat=person1]').classList.add('active')
// document.querySelector('.active').querySelector('.conversationLeftNoRead-active').classList.add('conversationLeftNoRead')
// /*chat======================================================================================================*/
