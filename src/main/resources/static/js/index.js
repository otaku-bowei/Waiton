$(function(){
    $.ajax({
        url:'/o_test/login',
        type: 'post',
        async : true,
        // 设置的是请求参数
        data:  '1' ,
        dataType: 'json',
        success: function(data) {
            $('#p_username').html("后台的账号");
            $('#p_password').html('后台账号密码');
        },
        error:function(err){
            //alert('发生错误');
        }
    });
});