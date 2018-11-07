//登入先判斷cookie是否有儲存帳號
$(document).ready(function(){
    var cookies = document.cookie;
    
    console.log(cookies);
    console.log(cookies.indexOf("email"));
    console.log(cookies.includes("email"));
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
                console.log(email+"facebook");
                if(data=="accountNoRepeat"){
                    console.log("帳號沒有重複");
                } else if (data==email+"facebook"){
                    alert("抓到FB帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    // window.location.href="http://localhost:8080/TeamWork/web/view/header.html"
                } else if (data==email+"google"){
                    alert("抓到Google帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    // window.location.href="http://localhost:8080/TeamWork/web/view/header.html"
                } else {
                    alert("抓到一般帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    // window.location.href="http://localhost:8080/TeamWork/web/view/header.html"
                }
                
            },
            error:function(data){
                console.log(data);
                alert("抓帳號cookie失敗")
            }
        });
    }
    /*
    //====設定cookie====================
    //expire_days = 1; // 過期日期(天)
    var date = new Date();
    //date.setTime(date.getTime() + (expire_days * 24 * 60 * 60 * 1000));
    date.setTime(date.getTime() + (60 * 1000));
    var expires = "expires=" + date.toGMTString();
    // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
    document.cookie = "name=test" + "; " + expires + '; path=/';
    alert(document.cookie)
    */

})