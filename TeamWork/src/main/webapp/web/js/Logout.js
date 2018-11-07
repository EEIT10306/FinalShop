//FB登出
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

//初始化
window.fbAsyncInit = function () {
    FB.init({
        appId: '333388330578468',
        cookie: true,
        xfbml: true,
        version: 'v3.2'
    });
};

function fbLogout(){
    console.log("FB登出1")
    FB.getLoginStatus(handleSessionResponse);
}

function handleSessionResponse(response) {
    if (response.status=='connected') {
        console.log("FB登出2")
        FB.logout();
        console.log("FB成功登出")
        history.go(0);
    }
}
//-----------------------------------------------------
//google登出
let Google_appId = "225653973483-ni23q4pk96dskb6ebku50s6o4omss7vq.apps.googleusercontent.com";

// Called when Google Javascript API Javascript is loaded
function HandleGoogleApiLibrary() {
    // Load "client" & "auth2" libraries
    gapi.load('client:auth2', {
        callback: function () {
            // Initialize client & auth libraries
            gapi.client.init({
                clientId: Google_appId,
                scope: 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me'
            }).then(
                function (success) {
                    // Google Libraries are initialized successfully
                    // You can now make API calls 
                    console.log("Google Libraries are initialized successfully");
                },
                function (error) {
                    // Error occurred
                    console.log(error);// to find the reason 
                }
            );
        },
        onerror: function () {
            // Failed to load libraries
            console.log("Failed to load libraries");
        }
    });
}

function signOut(data) {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
    auth2.disconnect();
    console.log('google登出');
    DelCookie(data)
    // location.reload()
}
//function signOut() {
//    var auth2 = gapi.auth2.getAuthInstance();
//    auth2.signOut().then(function () {
//        console.log('User signed out.');
//    });
//    console.log('google登出');
//    location.reload()
//}

//-----------------------------------------------------
//一般登出
$("#MemberLogout").click(function(e){

var cookies = document.cookie;

console.log(cookies);
console.log(cookies.split("email=")[1].split(";")[0]);

if(cookies==null|cookies==false|cookies==undefined|cookies=="undefined"){
    console.log("沒有cookie");
} else if(cookies.includes("email")){
    var email = cookies.split("email=")[1].split(";")[0];
    $.ajax({
        type:"post",
        url:"/TeamWork/checkAccount",
        data:{"m_account":email},
        success:function(data){
                console.log(data);
                if(data=="accountNoRepeat"){
                    console.log("帳號沒有重複");
                } else if (data==email+"facebook"){
                    alert("抓到FB帳號cookie")
                    fbLogout()         
                } else if (data==email+"google"){
                    alert("抓到Google帳號cookie")
                    signOut(email)
                } else {
                    alert("抓到一般帳號cookie")
                    DelCookie(data)
                }
            },
        error:function(data){
            console.log(data);
            alert("抓帳號cookie失敗")
            }   
        });
    }

})
//-----------------------------------------------------
//删除Cookie
function  DelCookie(name){
    alert("移除cookie ="+name)
    expire_days = -1; // 過期日期(天)
    var day = new Date();
    day.setTime(day.getTime() + (expire_days * 24 * 60 * 60 * 1000));
    var expires = "expires=" + day.toGMTString();
    document.cookie = "email="+ "" + "; " + expires + "; path=/";
    location.reload()
    // documents.cookie  =  name  +  "="  +  cval  +  ";  expires="+  exp.toGMTString();
}