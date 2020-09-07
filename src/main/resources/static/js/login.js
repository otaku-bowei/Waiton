window.onload=function(){
    var iusername=$('.username');
    var ipassword=$('.password');
    var btn_loginin=$('.loginin');
    var btn_register=$('.register');
    var content=$('.content');
    var radio_ClientType=$('.radioClientType');

    openOpacity();
    //opacity(content,0.1,1);


       btn_loginin.eq(0).on('click',function(){
           //var ClientType_check;
           /*
           if(radio_ClientType.eq(0).check())
           {
               ClientType_check=radio_ClientType.eq(0).val();
           }
           else{
               ClientType_check=radio_ClientType.eq(1).val();
           }*/
           ClientType_check=(radio_ClientType.eq(0).attr('checked')==1?ClientType_check=radio_ClientType.eq(0).val():ClientType_check=radio_ClientType.eq(1).val());
           alert(ClientType_check);

            $.ajax({
                type: "POST",
                async : true,
                // 设置的是请求参数
                data: { username:iusername.eq(0).val(), password:ipassword.eq(0).val(),clientType:ClientType_check},
                dataType: "text",
                url:"login",
                success: function(data) {
                    alert("hello world" + data);
                	//alert(typeof data);
                    if(data == "true"){
                    	//成功后跳转
                    	alert("hello world" + data);
                    	window.location.href='back.html';
                    }
                },
                error : function (err) {
                    alert("发生错误");
                }
            });

       });

    var passwordIcon=$('.passwordIcon');
    passwordIcon.on('click',function(event){
       // alert(1);
        if(ipassword.attr('type')=='password')
        {
            ipassword.attr('type','text');
            $(this).css('background-image',"url(images/view.png)");
        }
        else
        {
            ipassword.attr('type','password');
            $(this).css('background-image',"url(images/view_off.png)");
        }
        event.stopPropagation();
    });

    btn_register.on('click',function(){
        window.location.href='register.html';
    });
   }
   function openOpacity(){
        var openOpacity=null;
        var thisOpacity=null;
        openOpacity=setInterval(function(){
           thisOpacity=parseFloat($('.content').css('opacity'));
           thisOpacity+=0.1;
           $('.content').css('opacity',thisOpacity+"");
            if($('.content').css('opacity')==1)
            {
                clearInterval(openOpacity);
            }
       },80);
       
   }

   
  

    