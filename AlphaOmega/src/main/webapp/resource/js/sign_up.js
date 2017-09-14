/**
 * Created by chuliu on 2017/9/11.
 * 注册时的基本验证： 1.是否符合规则 2. 该用户(邮箱)已经注册过。
 */
$(document).ready(function(){

    $("#confirmPassword").on("blur",function () {
        //两次密码需要一致
        if ($("#confirmPassword").val() != $("#signUpPassword").val()){
           alert("password is different");
       }
    });


    $("#sign_up_form").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
        fields: {

                signUpEmail: {
                    validators: {
                        notEmpty: {
                            message: 'email should NOT empty'
                        },
                        emailAddress: {
                            message: 'Wrong email format'
                        }
                    }
                },
                displayName: {
                    validators: {
                        notEmpty: {
                            message: 'display name should NOT empty'
                        }
                    }
                },
                signUpPassword: {
                    validators: {
                        notEmpty: {
                            message: 'display name should NOT empty'
                        },
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: 'password should '
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: 'Only letter, number and _ allowed'
                        }
                    }
                },
                confirmPassword: {
                    validators: {
                        notEmpty: {
                            message: 'display name should NOT empty'
                        },
                        identical: {
                            field: 'signUpPassword',
                            message: 'The password and its confirm are not the same'

                        }
                    }

                }
            }
    });



    $("#sign_up_form").submit(function () {

        var result = false;

        $('#defaultForm').bootstrapValidator('validate');

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
