//========================FB登入==============================
//初始化
window.fbAsyncInit = function () {
    FB.init({
        appId: '333388330578468',
        cookie: true,
        xfbml: true,
        version: 'v3.2'
    });

    FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
    });
};

//引入 facebook SDK
(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
        return;
    js = d.createElement(s);
    js.id = id;
    js.src = "https://connect.facebook.net/zh_TW/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function statusChangeCallback(response) {
    if (response.status === 'connected') {
        console.log('Logged in and authenticated');
        //           setElements(true);
        testAPI();
    } else {
        console.log('Not authenticated');
        //           setElements(false);
    }
}

function checkLoginState() {
    FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
    });
}

function testAPI() {
    FB.api('/me?fields=name,first_name,last_name,email', function (response) {
        if (response && !response.error) {
            //========存取cookie============================
            var cookies =document.cookie; 
            console.log(cookies);
            console.log(response);
            console.log(response.name);
            if(cookies==null|cookies==false|cookies==undefined|cookies=="undefined"){
                console.log("沒有cookie");
            } else if(cookies.includes("email")){
                var email = cookies.split("email=")[1];
                $.ajax({
                    type:"post",
                    url:"/TeamWork/checkAccount",
                    data:{"m_account":email},
                    success:function(data){
                        console.log(data);
                        alert("抓帳號cookie成功是網站的帳號自動登入")
                    }
                });
            }
            // var exp =newDate();
            // exp.setTime(exp.getTime() + 60*1000);
            //7*24*60*60*1000 存活7天
            // cookies = response.name;
            $.ajax({
                type:"post",
                url: "/TeamWork/LoginFb",
                data: {
                    userInfo: JSON.stringify(response)
                },
                dataType: "json",
                async:false,
                success: function (data) {
                    alert("FB登入成功")
                    // document.getElementById('status').innerHTML =
                    //     'Thanks for logging in, ' + response.name + '!';
                }
            });
            //buildProfile(response);
        }
        //           FB.api('/me/feed', function(response){
        //             if(response && !response.error){
        //               buildFeed(response);
        //             }
        //           });
    })
}

// =================google登入==========================
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
    alert("google登出")
}

// 		function onSignIn(googleUser) {
// 			//跳?到http://gntina.iok.la/sendRedirect(?取用?信息)
// 			alert(profile.getEmail())
//              location.href = "www.google.com";
// 			//?取用?基本信息，但是此id不能?后台用，不安全，改用id_token
// 			/*??往下的代?都不需要，因?是在后台??，后台?取用?信息  */
//             var profile = googleUser.getBasicProfile();
// 			console.log('google自己封?好的?取用?信息');
// 			console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
// 			console.log('Name: ' + profile.getName());
// 			console.log('Image URL: ' + profile.getImageUrl());
// 			console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

// 			//?id_token?送?后台?行??
// 			/*var id_token = googleUser.getAuthResponse().id_token;
// 			var xhr = new XMLHttpRequest();
// 			xhr.open('POST', 'http://gntina.iok.la/idToken');
// 			xhr.setRequestHeader('Content-Type',
// 					'application/x-www-form-urlencoded');
// 			xhr.onload = function() {
// 				console.log('Signed in as: ' + xhr.responseText);
// 			};
// 			xhr.send('idtoken=' + id_token);
//                        */
// ?               }
function onSignIn(googleUser) {

    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    //測試有無進入google登入的方訊
    alert("這裡是google的登入:" + profile.getEmail())
    var id =profile.getId();
    var name = profile.getName();
    var email = profile.getEmail();
    var combie =  {"id":id , "name":name , "email" : email} ; 
    
    $.ajax({
        type: "POST",
        url: "/TeamWork/LoginGg",
        data: {
            userInfo: JSON.stringify(combie)
        },
        dataType: "json",
        success: function (data) {
            alert('這裡是google的登入成功後的方訊 :' + data);
            // window.location.href = "";
        }
    });
}