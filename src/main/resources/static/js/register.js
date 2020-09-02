$(function(){
    /*
        r_email:
    */
    var r_email=$('.r_email').eq(0);
    var r_password=$('.r_password:first');
    var r_username=$('.r_username:first');
    var timeout_checkEmailExist=null;
    var check_message=null;
   // $('.r_password_again').on('input propertychange',checkPassword);
    //$('.r_password').on('input propertychange',checkPassword);
    //$('.back').on('click',function back(){
    //    window.location.href='login.html';
    //});

    //input propertychange :文本变化事件
    r_email.on('input propertychange',{obj:r_email,timeout:timeout_checkEmailExist},checkEmailExist)
    
    //注册按钮事件
    

    
});




//检测该邮箱是否已注册
function checkEmailExist(event){
    clearTimeout(event.data.timeout);
    event.data.timeout=setTimeout(function(){
        $.ajax({
            type: "POST",
            async : true,
            // 设置的是请求参数
            data: { email:event.data.obj.val()},
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
                    //check_message=data;
                    $('.register').on('click',{registermessage:data},inputRegister);
                    $('.email_check:eq(0)').html("该邮箱可以使用").css('display','inline').css('color','green').css('font-size','12px');
                }
                
            },
            error : function (err) {
                alert("发生错误");
            }
        });
    },2000);
        
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
    alert($('.r_check_user_message').val());
    alert(event.data.registermessage);
    if($('.r_check_user_message:eq(0)').val()==event.data.registermessage){
    $.ajax({
        type: "POST",
        async : true,
        // 设置的是请求参数
        data: {email:$('.r_email').val(),username:$('.r_username:first').val(), password:$('.r_password:first').val()},
        dataType: "text",
        url:"register",
        success: function(data) {
            //alert(data);
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
    else{
        alert('注册错误');
    }
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