$(document).ready(function(){

    $("#select_language_submit").attr("href","/user/changeLanguage?lang="+"en_US");

    //获取Select的值，并拼接到方法里
    $("#select_language").change(
        function () {

            var language = $("#select_language").val();
            var language_code = '';

            switch (language) {
                case "English": language_code = "en_US";
                    break;
                case "Chinese": language_code = "zh_CN";
                    break;
                default : language_code = "en_US";
                    break;
            }

            $("#select_language_submit").attr("href","/user/changeLanguage?lang="+language_code);
        }
    );

});