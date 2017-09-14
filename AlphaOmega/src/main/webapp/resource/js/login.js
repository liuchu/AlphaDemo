$(document).ready(function(){

    $("#login_form").submit(function () {

        var result = false;
        var remember = "no";

        //如果选中，则记住
        if ($("#inputRemember").is(":checked")){
            remember = "yes";
        } 

        $("#inputRemember").val(remember);

        /*$.post("/user/doAuthenticate",
            {
                inputEmail:$("#inputEmail").val(),
                inputPassword:$("#inputPassword").val()
            },
            function(data,status,jqXHR){
                //alert("status:"+jqXHR.status);

                if(jqXHR.status == 200){
                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象
                    if (jsonObj.response == "success") {
                        $("#auth_response").html("success");
                        this.result = true;

                        //$("#login_form").submit();
                    }else {
                        $("#auth_response").html("Username or password NOT correct");
                    }

                }else{
                    $("#auth_response").html("Server error");
                }

            }
        );*/


        $.ajax({
            url : "user/doAuthenticate",
            data : {
                inputEmail:$("#inputEmail").val(),
                inputPassword:$("#inputPassword").val()
            },
            async : false,
            type:"POST",
            success : function(data,status,jqXHR){
                //alert("status:"+jqXHR.status);

                if(jqXHR.status == 200){
                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象
                    if (jsonObj.response == "success") {
                        result = true;
                        //$("#login_form").submit();
                    }else {
                        $("#auth_response").html("Username or password NOT correct");
                    }

                }else{
                    $("#auth_response").html("Server internal error");
                }

            },
            error : function (jqXHR) {
                $("#auth_response").html("can't connect server:");
            }

        });

        return result;
    });



});
