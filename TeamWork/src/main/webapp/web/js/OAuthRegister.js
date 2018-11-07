//========================FB登入==============================
//引入 facebook SDK
let FB_appID = "333388330578468";

(function (d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id))
        return;
    js = d.createElement(s);
    js.id = id;
    js.src = "https://connect.facebook.net/zh_TW/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

//初始化
window.fbAsyncInit = function () {
    FB.init({
        appId: '333388330578468',
        cookie: true,
        xfbml: true,
        version: 'v3.2'
    });
    // FB.getLoginStatus(function (response) {
    //     statusChangeCallback(response);
    // });
};

/*
function statusChangeCallback(response) {
    if (response.status === 'connected') {
        console.log('FB自動連線');
        //           setElements(true);
        registerAPI();
        
    } else {
        console.log('FB沒有自動連線');
        //           setElements(false);
    }
}
*/
//function checkLoginState() {
//    FB.getLoginStatus(function (response) {
//        statusChangeCallback(response);
//    });
//}

function FBlogin() {
    FB.login(function(response){
        FB.api('/me?fields=name,first_name,last_name,email', function (response) {
            if (response && !response.error) {
                console.log(response);
                $.ajax({
                    type:"post",
                    url: "/TeamWork/FBRegister",
                    data: {
                        userInfo: JSON.stringify(response)
                    },
                    success: function (data) {
                        //設定fbcookie
                        //expire_days = 1; // 過期日期(天)
                        var day = new Date();
                        //date.setTime(date.getTime() + (expire_days * 24 * 60 * 60 * 1000));
                        day.setTime(day.getTime() + (60 * 1000));
                        var expires = "expires=" + day.toGMTString();
                        // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
                        document.cookie = "email="+ data + "; " + expires + '; path=/';
                        alert(document.cookie)
                        //FB登入
                        alert("FB註冊成功")
                        window.location.href="http://localhost:8080/TeamWork/web/view/form_login.html"
                    },
                    error: function(data){
                        console.log(data);
                        console.log(response.email);
                        alert("FB註冊失敗")
                    }
                });
                //buildProfile(response);
            }
    })
    
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
    console.log('Google自動連線');
    alert("這裡是google的登入:" + profile.getEmail())
    var id =profile.getId();
    var name = profile.getName();
    var email = profile.getEmail();
    var combie =  {"id":id , "name":name , "email" : email} ; 
    
    $.ajax({
        type: "POST",
        url: "/TeamWork/GoogleRegister",
        data: {
            userInfo: JSON.stringify(combie)
        },
        success: function (data) {
            //設定Googlecookie
            //expire_days = 1; // 過期日期(天)
            var day = new Date();
            //date.setTime(date.getTime() + (expire_days * 24 * 60 * 60 * 1000));
            day.setTime(day.getTime() + (60 * 1000));
            var expires = "expires=" + day.toGMTString();
            // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
            document.cookie = "email="+ data + "; " + expires + '; path=/';
            alert(document.cookie)
            alert('google註冊成功 :' + data);
            window.location.href="http://localhost:8080/TeamWork/web/view/form_login.html"
            // window.location.href = "";
        },
        error:function (data) {
            alert('google登入失敗 :' + data);
        }
    });
}