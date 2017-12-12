/**
 * Created by chuliu on 2017/9/11.
 * 注册时的基本验证： 1.是否符合规则 2. 该用户(邮箱)已经注册过。
 */

function show_error(element,element_after,message) {
    element.css('border','1px solid #FF0000');
    element_after.html(message);

    $('#sign_up').attr('disabled','disabled');

}

function clear_error(element,element_after,message) {
    element.css('border','1px solid #08FF57');
    element_after.html(message);
    $('#sign_up').removeAttr('disabled');
}

$(document).ready(function(){

    //Validate email
    $("#signUpEmail").on("input",function () {
        var email = $("#signUpEmail").val();
        var pattern = /^\w+[\w\-\.]*\@\w+((-\w+)|(\w*))\.[a-z]{2,3}$/;

        if (!pattern.test(email)){
            show_error($("#signUpEmail"),$("#sign_up_p"),'Email is invalid');
        }else{
            clear_error($("#signUpEmail"),$("#sign_up_p"),'');
        }

    });

    //Validate display name
    $("#displayName").on("blur",function () {
        if ('' == $("#displayName").val()){
            show_error($("#displayName"),$('#display_name_p'),'Full name must not be empty');
        }else{
            clear_error($("#displayName"),$("#display_name_p"),'');
        }
    });
    
    //Validate password
    $("#signUpPassword").on("blur",function () {
        var pattern = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})/;

        //密码有字母数字，特殊字符组成
        if (!pattern.test($("#signUpPassword").val())){
            show_error($("#signUpPassword"),$('#sign_password_p'),'Password must begin with letter, length more than 6');
        }else{
            clear_error($("#signUpPassword"),$("#sign_password_p"),'');
        }
    });

    //Validate if confirmed password is the same
    $("#confirmPassword").on("blur",function () {
        //两次密码需要一致
        if ($("#confirmPassword").val() != $("#signUpPassword").val()){
            show_error($("#confirmPassword"),$('#confirm_password_p'),'Password is different');
        }else{
            clear_error($("#confirmPassword"),$("#confirm_password_p"),'');
        }
    });


    $("#sign_up_form").submit(function () {

        var result = false;

        $.ajax({
            url : "user/checkUsername",
            data : {
                signUpEmail:$("#signUpEmail").val()
            },
            async : false,
            type:"POST",
            success : function(data,status,jqXHR){
                //alert("status:"+jqXHR.status);

                if(jqXHR.status == 200){
                    var jsonObj = JSON.parse(data); //由JSON字符串转换为JSON对象
                    if (jsonObj.response == "no") { //不存在 则继续创建
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
