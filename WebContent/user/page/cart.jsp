<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pojo.CartAndBook,pojo.Cart,pojo.Book,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城购物车</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/cart.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a href="../page/search.html?title=Java" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="../page/index.html" >首页</a><b>|</b></li>
            <li><a href="../page/collect.html" >收藏</a><b>|</b></li>
            <li><a href="../page/order.html" >订单</a><b>|</b></li>
            <li><a href="allCartServlet" >购物车</a><b>|</b></li>
            <li><a href="../page/password-change.html">设置</a><b>|</b></li>
            <li><a href="../page/login.html">退出</a><b>|</b></li>
            <li><a href="../page/lookforward.html">帮助</a></li>
        </ul>
    </div>
</header>
<!-- nav主导航-->

<div class="modal" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            删除提醒
        </div>
        <div class="modal_information">
            <img src="../img/model/model_img2.png" alt=""/>
            <span>确定删除您的这个宝贝吗？</span>
        </div>
        <div class="yes"><span>删除</span></div>
        <div class="no"><span>不删除</span></div>
    </div>
</div>
<div class="modalNo" style="display:none">
    <div class="modal_dialog">
        <div class="modal_header">
            删除提示
            <img src="../img/model/model_img1.png" alt="" class="rt close"/>
        </div>
        <div class="modal_information">
            <img src="../img/model/model_img2.png" alt=""/>
            <span>请选择商品</span>
        </div>
    </div>
</div>
<div class="big">
    <form  name="" action="" method="post">
    <section id="section" >
        <div id="title">
            <b>购物车</b>
            <p>
                已选<span class="total color">0</span>件商品<span class="interval"></span>合计(不含运费):<span class="totalPrices color susum">0.00</span><span class="unit color">元</span>
            </p>
        </div>
        <div id="box" >
            <div id="content_box">
                <div class="imfor_top">
                    <div class="check_top">
                        <div class="all">
                            <span class="normal">
                                <img src="../img/cart/product_normal.png" alt=""/>
                            </span>  <input type="hidden" name="" value="">全选
                        </div>
                    </div>
                    <div class="pudc_top">商品</div>
                    <div class="pices_top">单价(元)</div>
                    <div class="num_top">数量</div>
                    <div class="totle_top">金额</div>
                    <div class="del_top">操作</div>
                </div>
<%
ArrayList<CartAndBook> list = (ArrayList<CartAndBook>)request.getAttribute("cabs");
for (int i = 0; i < list.size(); i++){
	CartAndBook cab = list.get(i);
	Cart cart = cab.getCart();
	Book book = cab.getBook();
%>
                <div class="imfor">
                    <div class="check">
                        <div class="Each">
                            <span class="normal">
                                <img src="../img/cart/product_normal.png" alt=""/>
                            </span>
                            <input type="hidden" name="" value="">
                        </div>
                    </div>
                    <div class="pudc">
                        <div class="pudc_information" id="<%=cart.getRid()%>">
                            <img src="../img/goods/9787115130228/detail1.jpg" class="lf"/>
                            <input type="hidden" name="" value="">
                        <span class="des lf">
                         C Primer Plus
                              <input type="hidden" name="" value="">
                        </span>
                            <p class="col lf"><span>作者：</span><span class="color_des">[美] 普拉塔（Prata S.） 著；云巅工作室 编  <input type="hidden" name="" value=""></span></p>
                        </div>
                    </div>
                    <div class="pices">
                        <p class="pices_des"></p>
                        <p class="pices_information"><b>￥</b><span>49.8<input type="hidden" name="" value=""></span></p>
                    </div>
                    <div class="num"><span class="reduc">&nbsp;-&nbsp;</span><input type="text" value="<%=cart.getCount() %>" ><span class="add">&nbsp;+&nbsp;</span></div>
                    <div class="totle">
                        <span>￥</span>
                        <span class="totle_information">49.8</span>
                    </div>
                    <div class="del">
                        <a href="javascript:;" class="del_d">删除</a>
                    </div>
                </div>
<%
}
%>
            </div>
            <div class="foot">
                <div class="foot_check">
                    <div class="all">
                        <span class="normal">
                                <img src="../img/cart/product_normal.png" alt=""/>
                            </span>  <input type="hidden" name="" value="">全选
                    </div>
                </div>
                <div class="foot_cash" id="go-buy">提交订单</div>
                <div class="foot_tol"><span>合计(不含运费):</span><span  class="foot_pices susumOne">0.00</span><span class='foot_des'>元</span></div>
                <div class="foot_selected">
                    已选<span class="totalOne color">0</span>件商品
                </div>
            </div>
        </div>
    </section>
    <div class="none" style="display: none">
      <p class="none_title">购物车</p>
      <div class="none_top"></div>
      <div class="none_content">
        <img src="../img/30.png" alt="" class="lf"/>
        <p class="lf">您的购物车竟然还是空哒( ⊙ o ⊙ )</p>
        <span class="lf">赶快去下单吧！</span>
        <a href="#" class="lf">去购物>></a>
      </div>
    </div>
    </form>
</div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../img/footer/wechat.png" alt=""/>
                    <img src="../img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="../img/footer/ios.png" class="lf">
            <img src="../img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../img/footer/erweima.png">
        </div>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/cart.js"></script>
<script src="../js/index.js"></script>
<script>
//去结算
var str=[];
$('.foot_cash').click(function(){
  $('.Each>span').each(function(){
    if($(this).hasClass('true')){
      var id=$(this).parent().parent().next().children('.pudc_information').attr('id');
//			var num=$(this).parent().parent().siblings('.num').children('input').val();
      str.push(id);
    }
  });
  console.log(str);
  if(str.length>0){
     var url = '../page/order-confirm.html';//'cartToOrder.action?itemIds='+str;
     window.location.href = url;
  }
});
$(function(){
    // 显示空购物车页面
    if($(".imfor").length==0) {
        $('#section').hide();
        $('.none').show();
    }
    //小计和加减
    //加
    $(".add").each(function() {
      $(this).click(function() {
        var $multi = 0;
        var vall = $(this).prev().val();
        vall++;
        $(this).prev().val(vall);
        $multi = (parseInt(vall).toFixed(2) * parseInt($(this).parent().prev().children().eq(1).children().eq(1).text()));
        $(this).parent().next().children().eq(1).text(Math.round($multi).toFixed(2));
        amountadd();
        var id=$(this).parent().siblings('.pudc').children('.pudc_information').attr('id');
        var num=$(this).prev().val();
        $.ajax({
          type: "GET",
          url: "changeItemNum.action",
          data: {itemId:id,num:num},
          success: function(data){
          }
        });
      })
    });
    //减
    $(".reduc").each(function() {
  		$(this).click(function() {
  			var $multi1 = 0;
  			var vall1 = $(this).next().val();
  			vall1--;
  			if(vall1 <= 0) {
  				vall1 = 1;
  			}
  			$(this).next().val(vall1);
  			$multi1 = parseInt(vall1) * parseInt($(this).parent().prev().children().eq(1).children().eq(1).text());
  			$(this).parent().next().children().eq(1).text(Math.round($multi1).toFixed(2));
  			amountadd();
  			var id=$(this).parent().siblings('.pudc').children('.pudc_information').attr('id');
  			var num=$(this).next().val();
  			$.ajax({
  				type: "GET",
  				url: "changeItemNum.action",
  				data: {itemId:id,num:num},
  				success: function(data){

  				}
  			});
  		})
	   });
    // 删除当前行
    $('.del_d').click(function() {
        var id=$(this).parent().siblings('.pudc').children('.pudc_information').attr('id');
        console.log(id);
        $('.modal').fadeIn();
        $('.no').click(function(){
          $('.modal').fadeOut();
        });
        $('.yes').click(function(){
          var url ='deleteCartItem.action?itemId='+id;
           window.location.href=url;
        })
    });
});
</script>
</body>
</html>
