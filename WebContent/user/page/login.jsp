<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城学子登陆页面</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/login.css" rel="stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div class="top">
        <img src="../img/header/logo.png" alt=""/>
        <span>欢迎登录 JRS</span>
    </div>
</header>
<div id="container">
    <div id="cover" class="rt">
        <form id="fm-login" name="form1" method="post" action="userLoginServlet" >
            <div class="txt">
                <p>登录JRS商城
                    <span>
                        <a href="regist.jsp">新用户注册</a>
                    </span>
                </p>
                <div class="text">
                    <input type="text" placeholder="请输入您的用户名" name="uname" id="uname" required>
                    <span></span>
                </div>

                <div class="text">
                    <input type="password" id="upwd" placeholder="请输入您的密码" name="upwd" required minlength="6" maxlength="15">
                    <span></span>
                </div>
                <div class="chose">
					
                </div>
                <input class="button_login" type="submit" value="登录" id="bt-login" />
            </div>
        </form>
    </div>
</div>
<!--错误提示-->
<div id="showResult"></div>
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
        
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    $("#uname").blur(function(){
        var data = $("#uname").val();
        if (data == null || data == "") {
            $("#showResult").text("用户名不能为空！");
            $("#showResult").css("color","red");
            return false;
        }
        $.ajax({
            type:"POST",
            url:"unameCheck.action",
            data:"uname="+data,
            beforeSend:function(XMLHttpRequest)
            {
                $("#showResult").text("正在查询");

            },
            success:function(msg)
            {
                if(msg ==="yes"){
                    $("#showResult").text("");
                }else if(msg === 'no'){
                    $("#showResult").text("该用户不存在");
                    $("#showResult").css("color","red");
                }
            },
            error:function()
            {
                //错误处理
            	$("#showResult").text("系统异常！");
                $("#showResult").css("color","red");
            }
        });
    });
    /* $('#bt-login').click(function(){
        window.location.href =  "index.html";
        //读取用户的输入——表单序列化
        var inputData = $('#fm-login').serialize();
        // alert(inputData);
        //异步提交请求，进行验证
        $.ajax({
        	async: true,
            type: 'POST',
            url: 'login.action',
            data: inputData,
            success: function(txt, msg, xhr){
            	// alert("*"+txt+"*");
                if(txt=='yes'){  //登录成功
                    var loginName = $('[name="uname"]').val();
                    console.log(loginName);
                    window.location.href =  "index.html";
                }else{ //登录失败
                    $('#showResult').html('登录失败！');
                }
            }
        });
    }); */
</script>
</body>
</html>
