$("#Login").click(function(e){

    var account = $("[name='email']").val();
    var password = $("[name='password']").val();

    $.ajax({
        type:"post",
        url:"/TeamWork/LoginServlet",
        data:{"m_account":account,"m_password":password},
        
        success:function(data){
            // alert(data);
            $("#errorAccount").html("")
            $("#errorPassword").html("")
            
            if(data=="accountNull"){
                $("#errorAccount").html("請輸入帳號")
            }
            if(data=="passwordNull"){
                $("#errorPassword").html("密碼須包含大寫字母、小寫字母、數字與特殊字元，且長度不能小於八個字元")
            }
            if(data[0].m_account== account){
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
                // alert(document.cookie)

                // alert("登入成功")
                window.location.href=window.history.back();
                
                
            }
            if(data== "beanNull"){
                $("#errorAccount").html("該帳號不存在或密碼錯誤")
            }
            
        }


    })
})