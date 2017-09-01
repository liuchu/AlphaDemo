$(document).ready(function(){

    $("#sign_in").click(function () {
        var email = $("#inputEmail").val();
        alert(email);
        if ("liuchuu@126.com"==email){
            $("#login_form").submit();
        }else{
            $("#auth_response").html("Server error");
        }
    });

    //点击登陆按钮
    function auth() {

        alert("authing");

        $.ajax({

            url: "/user/doAuthenticate",
            contentType: "text/html;charset=UTF-8",
            context: document.body,
            type:"POST",
            dataType:"json",
            success: function(data){
                //obj = JSON.parse(data);
                alert(data);
                if("{response:success}" ==  data)
                    $("#auth_response").html(data);
            },
            error: function (data) {
                $("#auth_response").html("Server error");
            }

        });

        return false;
    }

});