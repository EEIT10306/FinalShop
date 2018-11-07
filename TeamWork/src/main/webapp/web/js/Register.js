$("#register").click(function(e){

    var mail = $("[name = 'email']").val();
    var password = $("[name = 'password']").val();
    var repassword = $("[name = 'repassword']").val();
    var name = $("[name = 'name']").val();
    
//      var combie = {"account":mail,"name":name , "password":password};
//      var json   = JSON.stringify(combie);
//      alert(json) ;
    
    if (password == repassword){
        $("#errorAccount").html("")
        $("#errorPassword").html("")
        
        $.ajax({
            type: "post",
            url : "/TeamWork/RegisterServlet",
            data: {"m_account":mail,"m_name":name , "m_password":password,"m_mail":mail},
            success: function(data) {
                console.log(data)
                if(data=="accountNull"){
                    $("#errorAccount").html("請輸入欄位")
                }
                if(data=="existsAccount"){
                    $("#errorAccount").html("此帳號已被使用")
                }
                if(data=="passwordNull"){
                    $("#errorPassword").html("密碼必須包含大寫字母、小寫字母、數字與特殊字元，且長度不能小於八個字元")
                }
                if(data == mail){
                    console.log("成功註冊")
                    //設定cookie
                    var expire_days = 1; // 過期日期(天)
                    var day = new Date();
                    day.setTime(day.getTime() + (expire_days * 24 * 60 * 60 * 1000));
                    // day.setTime(day.getTime() + (60 * 1000)); //測試用cookie時間
                    var expires = "expires=" + day.toGMTString();
                    // document.cookie = "name=test" + "; " + expires + '; domain=localhost:8080; path=/';
                    document.cookie = "email="+ data + "; " + expires + '; path=/';
                    alert(document.cookie)
                    alert("註冊成功")
                    window.location.href="http://localhost:8080/TeamWork/web/view/form_login.html";
                } 
            },
            error: function(data){
                console.log("註冊失敗"+data)
            }
        });
    } else {
        $("#errorPassword").html("請輸入相同密碼")
    }

    
})