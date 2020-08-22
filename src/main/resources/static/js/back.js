$(function(){

    
        $.ajax({
            url:'getUsername',
            type: 'post',
            async : false,
            // 设置的是请求参数
            data: { 'username':iusername.eq(0).val(), 'password':ipassword.eq(0).val() },
            dataType: 'text',
            success: function(data) {
                //alert(typeof data);
            	$('#loginIdText').html(data);
                
            },
            error:function(err){
                alert('发生错误');
            }
        });
	
    $('#topNav').width($(window).width()-100);
    $('#backNav').width($(window).width()-100);
    $('#backRightContent').outerWidth($('#backNav').outerWidth()-$('#backLeft').outerWidth());

    /*
    $('#span_xgxx').on({
        mouseover:function(){
            $('#span_xgxx').css('color','rgb(100, 100, 100)');
            
        },
        mouseout:function(){
            $('#span_xgxx').css('color','rgb(126, 126, 126)');
        }
    });*/
    
    var li_list=$('#backLeft').find('li');
    var li_list_number=0;
    var backRightContent_list=$('#backRightContent').children('div');
    //alert(backRightContent_list.length);
    li_list.on('click',function(event){
        //alert($(this).index());
        if(li_list_number!=$(this).index())
        {
            backRightContent_list.eq(li_list_number).toggle();
            backRightContent_list.eq($(this).index()).toggle();
            li_list_number=$(this).index();
        }
        return false;
    });

    

    $('#span_xgxx').on('click',function(){
        if($('.zhgl_2').attr('onOff')=='on'){
            $('.zhgl_2').animate({height:30},300);
            $('.zhgl_2').attr('onOff','off');
            $('#span_xgxx').css('color','');
            //$('#span_xgxx').removeAttr('color');
            
        }
        else{
            $('.zhgl_2').animate({height:150},300);
            $('.zhgl_2').attr('onOff','on');
            $('#span_xgxx').css('color','rgb(100, 100, 100)'); 

            
        }
       // $('.zhgl_2').animate({height:150},1000);
    });


    $(window).on('resize',windowResize);
    //alert($('#backRightContent').children('div').eq(1).html());
    
    
    /*
        $('#indexLeft').animate({height:"300px"},"100",function(){
            $('#indexLeft').animate({height:"50px"},"fast",function(){
                $('#indexLeft').animate({height:"300px"},"100",function(){
            
                });
            });
        });*/

        //页面左边弹出动画
        /*
        $('#backLeft').animate({
            width: 253,
            height: '240px',
            marginLeft: -20,
            opacity:0.8,
            
        }, 100 ).animate({
            width: 223,
            height: '230px',
            marginLeft: -10,
            opacity:0.9
        }, 100 ).animate({
            width: 253,
            height: '240px',
            marginLeft: -20,
            opacity:1
        }, 100 )*/
 
        

    

    $('#loginIdText').on('click',function(){});
});

//当窗体发生改变时组件大小自适应改变
function windowResize(){
    $('#topNav').width($(window).width()-100);
    $('#backRightContent').width($('#topNav').width()-$('#backLeft').width()-100);
    $('#backNav').width($(window).width()-100);
    $('#backRightContent').outerWidth($('#backNav').outerWidth()-$('#backLeft').outerWidth());
}