$(function(){
    /*
        r_email:
    */
    var text_email=$('.r_email').eq(0);
    var text_password=$('.r_password:first');
    var text_username=$('.r_username:first');
    var timeout_checkEmailExist=null;
    
    $('.r_password_again').on('input propertychange',checkPassword);
    //$('.r_password').on('input propertychange',checkPassword);
    //$('.back').on('click',function back(){
    //    window.location.href='login.html';
    //});

    //input propertychange :文本变化事件
    text_email.on('input propertychange',{email:text_email,timeout:timeout_checkEmailExist},checkEmailExist)
    
    //注册按钮事件
    

    
});




//检测该邮箱是否已注册
function checkEmailExist(event){
    clearTimeout(event.data.timeout);
    
    $('.btn_register_message').off('click',requestMessageSend);
    event.data.timeout=setTimeout(function(){
        if(checkEmailIsTrue()){
            $.ajax({
                type: "POST",
                async : true,
                // 设置的是请求参数
                data: {email:event.data.email.val(),clientType:1},
                dataType: "text",
                url:"checkUser",
                success: function(data) {
                    //alert(data);
                    if(data=="false")
                    {
                       
                        $('.email_check:eq(0)').html("该邮箱已被注册").css('display','inline').css('color','red').css('font-size','12px');
                        return false;
                    }
                    else
                    {
                        //btn_register_message绑定点击事件
                        $('.btn_register_message').on('click',{email:event.data.email},requestMessageSend);
                        $('.email_check:eq(0)').html("该邮箱可以使用").css('display','inline').css('color','green').css('font-size','12px');
                    }
                    
                },
                error : function(err) {
                    alert("发生错误");
                }
            });
        }
    },1000);
        
}


//请求发送验证码
function requestMessageSend(event){
    $('.register').off('click',inputRegister);
    $.ajax({
        type: "POST",
        async : true,
        data: {email:$('.r_email:eq(0)').val()},
        dataType: "text",
        url:"sendMessage",
        success: function(data) {
                alert('验证码已发送');
                $('.register').on('click',inputRegister);
                sendMessageInterval();
                
        },
        error : function (err) {
            alert("发生错误");
        }
    });
}

//检查账号名是否为空
function checkUsernameIsNull(){
    if($('.r_username:eq(0)').val()=='')
    {
        alert("账号不能为空");
        return false;
    }
}

//注册按钮事件实现注册
function inputRegister(event){
    //checkUsernameIsNull();
    //alert($('.r_check_user_message').val());
    $.ajax({
        type: "POST",
        async : true,
        // 设置的是请求参数
        data: {email:$('.r_email').val(),username:$('.r_username:first').val(), password:$('.r_password:first').val(),message:$('.r_check_user_message').val()
           ,clientType:1
        },
        dataType: "text",
        url:"register",
        success: function(data) {
            alert(data);
            switch(data)
            {
                case "true":{
                    alert('注册成功');
                    window.location.href="login.html"
                    break;
                }
                case "false":{
                    alert("验证码错误");
                    break;
                }
                default:{
                    alert('注册失败');
                }

            }     
        },
        error : function (err) {
            alert("发生错误");
        }
    });
}




//检查两个密码是否相同
function checkPassword(){
    if($('.r_password').val()=='')
    {
        $('.password_check').eq(0).html('未输入密码！').css('color','red').css('display','inline');
    }
    if($('.r_password').val()!=$('.r_password_again').val())
    {
        $('.password_check').eq(0).html('两次密码不相同！').css('color','red').css('display','inline').css('font-size','15px');
    }
    if($('.r_password').val()==$('.r_password_again').val()){
        $('.password_check').eq(0).css('display','none');
    }
}

//判断邮箱input的合法性
function checkEmailIsTrue(){
    //loading
    var check = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/; //
        if (!check.test($('.r_email:eq(0)').val())) { 
            $('.email_check:eq(0)').html("邮箱格式错误").css('display','inline').css('color','red').css('font-size','12px');
            return false;
        } else {
            return true;
        }

}




//发送验证码计时器
function sendMessageInterval(){
    $('.btn_register_message').css('background-color','rgb(201, 201, 201)').val('验证码已发送').off('click');
    var span_timeOut=30;
    var timeOut=null
    timeOut=setInterval(function(){
        $('#span_register_message').html(span_timeOut);
        span_timeOut--;
        if(span_timeOut==0)
        {
            
            $('#span_register_message').html("");
            $('.btn_register_message').val("发送验证码");
            $('.btn_register_message').css('background-color','');
            $('.btn_register_message').on('click',requestMessageSend);
            clearInterval(timeOut);
            return true;
            //$('.span_register_message').html("");
        }
    },1000);
    //$('.span_register_message').html("");
    //alert("wan");
}