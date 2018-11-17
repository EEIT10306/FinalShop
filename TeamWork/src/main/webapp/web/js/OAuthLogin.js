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

//     FB.getLoginStatus(function (response) {
//         statusChangeCallback(response);
//     });
};

function statusChangeCallback(response) {
    if (response.status === 'connected') {
        console.log('FB自動連線');
       
        loginAPI();
    } else {
        console.log('FB沒有自動連線');
        //           setElements(false);
        loginAPI();
    }
}

function checkLoginState() {
    FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
    });
}

function loginAPI() {
    FB.login(function(response){
        FB.api('/me?fields=name,first_name,last_name,email', function (response) {
            if (response && !response.error) {
                
                var cookies =document.cookie; 
                console.log(cookies);
                console.log(response);
                console.log(response.email);
                $.ajax({
                    type:"post",
                    url:"/TeamWork/LoginFb",
                    data:{userInfo: JSON.stringify(response)},
                    success:function(data){
                        console.log("=============FB資料");
                        console.log(data);
                        console.log(response.email);
                        
                        if(data=="existsAccount"){
                            console.log('此帳號沒註冊或者重複');
                        } else if(data[0].m_account==response.email) {
                             //設定cookie
                            expire_days = 1; // 過期日期(天)
                            var day = new Date();
                            day.setTime(day.getTime() + (expire_days * 24 * 60 * 60 * 1000));
                            // day.setTime(day.getTime() + (60 * 1000));
                            var expires = "expires=" + day.toGMTString();
                            // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
                            document.cookie = "email="+ data[0].m_account + "; " + expires + "; path=/";
                            document.cookie = "mid="+ data[0].m_id + "; " + expires + "; path=/";
                            document.cookie = "e_mail="+ data[0].m_mail + "; " + expires + "; path=/";
                            alert(document.cookie)
    
                            alert("登入成功")
                            window.location.href=window.history.back();
                        }
                        
                        // document.getElementById('status').innerHTML =
                        //     'Thanks for logging in, ' + response.name + '!';
                    },
                    error: function(data){
                        console.log(data);
                        console.log(response.email);
                        if(data=="beanNull"){
                            alert("FB登入失敗")
                        }
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
    })
    
}

// ================================================google登入==========================

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
    console.log('google登出');
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
    console.log("google開始登入");
    var profile = googleUser.getBasicProfile();
    //測試有無進入google登入的方訊
    var id =profile.getId();
    var name = profile.getName();
    var email = profile.getEmail();
    var combie =  {"id":id , "name":name , "email" : email} ; 
    console.log(combie);
    $.ajax({
        type: "POST",
        url: "/TeamWork/LoginGg",
        data: {
            userInfo: JSON.stringify(combie)
        },
        success: function (data) {
            console.log(data);
            if(data=="existsAccount"){
                console.log('此帳號沒註冊或者重複');
            } else if(data[0].m_account==email) {
            	//設定cookie
                expire_days = 1; // 過期日期(天)
                var day = new Date();
                day.setTime(day.getTime() + (expire_days * 24 * 60 * 60 * 1000));
                // day.setTime(day.getTime() + (60 * 1000));
                var expires = "expires=" + day.toGMTString();
                // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
                document.cookie = "email="+ data[0].m_account + "; " + expires + "; path=/";
                document.cookie = "mid="+ data[0].m_id + "; " + expires + "; path=/";
                document.cookie = "e_mail="+ data[0].m_mail + "; " + expires + "; path=/";
                alert(document.cookie)

                alert("登入成功")
                window.location.href=window.history.back();
            }
        },
        error:function (data) {
            alert('google登入失敗 :' + data);
        }
    });
}

