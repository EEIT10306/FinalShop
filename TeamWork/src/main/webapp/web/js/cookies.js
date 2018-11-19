//登入先判斷cookie是否有儲存帳號
// var Memberallbean;
$(document).ready(function(){
	
	var cookies = document.cookie;
    //===================CookieToJson=======================
    function cookiesToJson() {
        //cookie分割並去掉所有空白字串
        let cookieArr = document.cookie.replace(/\s/g, "").split(";");
        let obj = {}
        cookieArr.forEach((i) => {
            let arr = i.split("=");
            obj[arr[0]] = arr[1];
        });
        return obj
    }
    
    if(cookies==null|cookies==false|cookies==undefined|cookies=="undefined"){
        console.log("沒有cookie");
    } else if(cookies.includes("email")){
        var json = cookiesToJson();
        console.log(json)
        var cookieAccount = json['email'];
        $.ajax({
            type:"post",
            url:"/TeamWork/checkAccount",
            data:{"m_account":cookieAccount},
            success:function(data){
                console.log(data);
                if(data=="accountNoRepeat"){
                    console.log("帳號沒有重複");
                } else if (data[0].m_password=="facebook"){
//                    alert("抓到FB帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    $("#navbarDropdownMenuLink").show();
                    $("#membernotice").show();
                } else if (data[0].m_password=="google"){
//                    alert("抓到Google帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    $("#navbarDropdownMenuLink").show();
                    $("#membernotice").show();
                    // window.location.href="http://localhost:8080/TeamWork/web/view/header.html"
                } else {
//                    alert("抓到一般帳號cookie")
                    $("[name='MemberLogin']").hide();
                    $("[name='MemberName']").show();
                    $("[id='MemberLogout']").show();
                    $("#navbarDropdownMenuLink").show();
                    $("#membernotice").show();
                    // window.location.href="http://localhost:8080/TeamWork/web/view/header.html"
                }
                $("[name='spanMemberName']").text(data[0].m_name)
                // Memberallbean=data;
                // console.log("Memberallbean======");
                // console.log(Memberallbean);
            },
            error:function(data){
                console.log("抓帳號cookie失敗");
//                alert("抓帳號cookie失敗")
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