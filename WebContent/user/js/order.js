/**
 * Created by yy on 2016/12/15.
 */
$("#leftsidebar_box dt").css({"background-color":" #0AA1ED"});
$(function(){
    $("#leftsidebar_box dd").hide();
    $("#leftsidebar_box .my_order dd").show();
    $("#leftsidebar_box dt").click(function(){
        $("#leftsidebar_box dt").css({"background-color":"#0AA1ED"});
        $(this).css({"background-color": "#0AA1ED"});
        $(this).parent().find('dd').removeClass("menu_chioce");
        $("#leftsidebar_box dt img").attr("src","../img/myOrder/myOrder2.png");
        $(this).parent().find('img').attr("src","../img/myOrder/myOrder1.png");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
        $(this).parent().find('dd').addClass("menu_chioce");
        $(this).parent().siblings().children('dd').slideUp();
    });
})
