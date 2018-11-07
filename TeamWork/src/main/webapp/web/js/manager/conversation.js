$(document).ready(function () {
     getConversation();
})

function getConversation() {
    var conversationTalker;
    var conversationContext;
    var conversationDate;
    var conversationShowTime;
    var showConversation = "";
    var count = 0;
    $.ajax({
        type: "POST",
        url: "/TeamWork/Manager",
        data: { "m_id": 25 },
        success: function (response) {
            console.log(response)
            count = response.length;

            for (var x = 0; x < count; x++) {
                conversationTalker = (response[x][0].m_id == 25) ? response[x][0].memberConversation.m_name : response[x][0].member.m_name;// 最後發話人是此人嗎
                conversationContext = response[x][0].c_context;
                conversationDate = new Date(response[x][0].c_time);
                conversationShowTime = (conversationDate.getMinutes().toString.length == 1) ? conversationDate.getHours() + ":0" + conversationDate.getMinutes() : conversationShowTime = conversationDate.getHours() + ":" + conversationDate.getMinutes();// 分之前是否要加0
                console.log(conversationTalker + "\n" + conversationContext + "\n" + conversationShowTime)

                showConversationTalker(conversationTalker, conversationContext, conversationShowTime, showConversation, x+1);
            }
//            console.log(showConversation)
//            count++
            displayNoneTalker(count);
        }

    });
}

function showConversationTalker(conversationTalker, conversationContext, conversationShowTime, showConversation, x) {
    $("li[data-chat=person"+x+"] span.name").html(conversationTalker)
    $("li[data-chat=person"+x+"] span.time").html(conversationShowTime)
    $("li[data-chat=person"+x+"] span.preview").html(conversationContext.substr(0, 10) + '...')
}

function displayNoneTalker(count){
	var a = 0;
	a = count;
	for (a++;a<=6;a++){
   	 document.querySelector('.person[data-chat=person'+a+']').classList.add('dis')
   }
}

function showConversationContext(){
	
}


$("li.person").click(function(){
    $("ul.people").toggleClass("active")
})

