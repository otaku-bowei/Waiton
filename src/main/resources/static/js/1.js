window.onload = function () {
    var iusername = document.getElementsByClassName("username");
    var ipassword = document.getElementsByClassName("password");
    var btn_loginin = document.getElementsByClassName("loginin");
    var btn_register = document.getElementsByClassName("register");
    var xhr = null;

    btn_loginin[0].onclick = function () {

        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhr.open('post', '/o_test/login', true);

        xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
        xhr.send('username=' + iusername[0].value + '&password=' + ipassword[0].value);

        //xhr.send();
        //alert(typeof iusername[0].value);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {

                    //var json=null;
                    // json=JSON.parse(xhr.responseText);
                    // alert(JSON.stringify(json));
                    //iusername[0].value=json.username[0];
                    //ipassword[0].value=json.password[0];
                    //alert(typeof JSON.stringify(xhr.responseText));
                    alert(xhr.responseText);
                } else {
                    alert("出错了" + xhr.status);
                }
            }
        }
    }
}
    
    