$(function(){
    $('.r_password_again').on('input propertychange',check);
    $('.r_password').on('input propertychange',check);
    $('.back').on('click',function back(){
        window.location.href='login.html';
    });
})


//检查两个密码是否相同
function check(){
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