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
    FB.init({appId: '333388330578468'});
    FB.getLoginStatus(handleSessionResponse);
}

function handleSessionResponse(response) {
    if (response.status=='connected') {
    FB.logout();
    }
}

$("#MemberLogout").click(function(e){

var cookies = document.cookie;

console.log(cookies);
console.log(cookies.split("email=")[1]);

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
            if(data=="accountNoRepeat"){
                console.log("帳號沒有重複");
            } else if (data==email+"facebook"){
                alert("抓到FB帳號cookie")
                fbLogout()
                
            } else if (data==email+"google"){
                alert("抓到Google帳號cookie")
                
                
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