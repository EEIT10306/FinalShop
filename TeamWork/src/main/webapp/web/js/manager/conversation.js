$(document).ready(function () {
    getConversation();
})

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
                conversationShowTime = (conversationDate.getMinutes().toString.length == 1) ? conversationDate.getHours() + ":0" + conversationDate.getMinutes() : conversationShowTime = conversationDate.getHours() + ":" + conversationDate.getMinutes();// 分之前是否要加0
                conversationId = (response[x][0].m_id == 25) ? response[x][0].memberConversation.m_id : response[x][0].member.m_id;

                showConversationTalker(conversationId, conversationTalker, conversationContext, conversationShowTime, x + 1);

                responseNow = response[x]
                showConversationContext(responseNow, x + 1);
            }
            chatjs();
        }
    });
}

function resetConversation() {
    $("ul#conversation_page").html("");
    $("div#contextIn").html("");
}

function showConversationTalker(conversationId, conversationTalker, conversationContext, conversationShowTime, x) {
    var showConversationTalker = "";
    showConversationTalker += `
        <li class="person" data-chat="person` + x + `">
            <input type = "hidden" id="conversationId" value="` + conversationId + `">
            <img src="../images/form-cat.png" alt="" />
            <span class="name">` + conversationTalker + `</span>
            <span class="time">` + conversationShowTime + `</span>
            <span class="preview">` + conversationContext + `</span>
        </li>
    `
    $("ul#conversation_page").append(showConversationTalker);
}

function showConversationContext(responseNow, x) {
    countContext = responseNow.length;
    var whatTime;
    var whatTimeLast;
    var showConversationContext = "";
    showConversationContext += '<div class="chat" data-chat="person' + x + '">';
    for (var y = countContext - 1; y >= 0; y--) {
        allConversationDate = new Date(responseNow[y].c_time);
        youOrMe = (responseNow[y].m_id == 25) ? 'me' : 'you';
        youOrMeTime = (responseNow[y].m_id == 25) ? 'conversationBlockTimeRight' : 'conversationBlockTimeLeft';
        conversationTime = (allConversationDate.getMinutes().length < 10) ? allConversationDate.getHours() + ':0' + allConversationDate.getMinutes() : allConversationDate.getHours() + ':' + allConversationDate.getMinutes();
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
/*sendNewConversation======================================================================================================*/
function sendNewConversation() {
    var c_context = $("#sendMe").val();
    var m_idConversation = $(".active #conversationId").val();
    alert(c_context);
    alert(m_idConversation);
    $("#sendMe").val("");
    alert($("#sendMe").val());
    $.ajax({
        type: "post",
        url: "/TeamWork/Manager.sendNewConversation",
        data: { m_id: 25, c_context: c_context, m_idConversation: m_idConversation },
        success: function (response) {
            alert(response)
            console.log(response)
            var conversationTime = new Date(response.c_time);
            conversationTime = (conversationTime.getMinutes().length < 10) ? conversationTime.getHours() + ':0' + conversationTime.getMinutes() : conversationTime.getHours() + ':' + conversationTime.getMinutes();
            showConversationContext = `
                <div>
                    <div class="bubble me">` + response.c_context + `</div>
                    <span class="conversationBlockTimeRight">` + conversationTime + `</span>
                </div>
            `;
        $("div.active-chat").append(showConversationContext)

        }
    });
}

$("#sendMe").keyup(function (e) {
    if (e.keyCode == 13) {
        sendNewConversation();
    }
});

/*chat======================================================================================================*/
function chatjs() {
//        document.querySelector('.chat[data-chat=person1]').classList.add('active-chat')
//        document.querySelector('.person[data-chat=person1]').classList.add('active')

    let friends = {
        list: document.querySelector('ul.people'),
        all: document.querySelectorAll('.left .person'),
        name: ''
    },
        chat = {
            container: document.querySelector('.container-box .right'),
            current: null,
            person: null,
            name: document.querySelector('.container-box .right .top .name')
        }

    friends.all.forEach(f => {
        f.addEventListener('mousedown', () => {
            f.classList.contains('active') || setAciveChat(f)
        })
    });

    function setAciveChat(f) {
        if (friends.list.querySelector('.active') != null) {
            friends.list.querySelector('.active').classList.remove('active')
        }
        f.classList.add('active')
        chat.current = chat.container.querySelector('.active-chat')
        chat.person = f.getAttribute('data-chat')
        if (chat.current != null) {
            chat.current.classList.remove('active-chat')
        }
        chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat')
        friends.name = f.querySelector('.name').innerText
        chat.name.innerHTML = friends.name

        var scrollHeight = $('div.chat').prop("scrollHeight");
        $("div.chat").scrollTop(scrollHeight, 200);
    }
}
/*chat======================================================================================================*/