/**
 * Created by chuliu on 2017/9/11.
 * 注册时的基本验证： 1.是否符合规则 2. 该用户(邮箱)已经注册过。
 */
$(document).ready(function(){

    $("#sign_up_form").submit(function () {

        var result = false;

        $.ajax({
            url : "user/checkUsername",
            data : {
                signUpEmail:$("#signUpEmail").val(),
                displayName:$("#displayName").val(),
                signUpPassword:$("#signUpPassword").val()
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
                        $("#sign_up_response").html("Email "+$("#signUpEmail").val()+" already existed");
                    }

                }else{
                    $("#sign_up_response").html("Server internal error");
                }

            },
            error : function (jqXHR) {
                $("#sign_up_response").html("can't connect server:");
            }

        });

        return result;
    });
});
