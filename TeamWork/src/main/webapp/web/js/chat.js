
function chatjs() {
  /* chat====================================================================================================== */
//  document.querySelector('.chat[data-chat=person1]').classList.add('active-chat')
//  document.querySelector('.person[data-chat=person1]').classList.add('active')
//  document.querySelector('.active').querySelector('.conversationLeftNoRead-active').classList.add('conversationLeftNoRead')
  divBottom();

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
      reading($(".active #conversationId").val());
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
    
    if(friends.list.querySelector(".conversationLeftNoRead")!=null){
    	friends.list.querySelector(".conversationLeftNoRead").classList.remove('conversationLeftNoRead')    	
    }
	friends.list.querySelector(".active .conversationLeftNoRead-active").classList.add("conversationLeftNoRead")
	 
    divBottom(); 
 
    $('input#sendMe').focus(); 
  }
}

function divBottom() {
  $('div.chat').scrollTop(100000)
  $('div.active-chat').scrollTop(100000)
}
