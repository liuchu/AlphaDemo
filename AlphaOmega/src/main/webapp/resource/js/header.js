$(document).ready(function(){

    //Click submit
    $("#create_submit").click( function () {

        $("#create_form").submit();
    });

    //修复modal只能弹出一次的问题
    $("#my_modal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
    });

});
