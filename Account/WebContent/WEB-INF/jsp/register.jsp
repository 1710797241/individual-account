<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/css/register.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
</head>
<body>
		<div class="register_head">
			<div class="register_logo">
				<h2>个人资金账户管理系统</h2>
				<img />
			</div>
			<span>
				<a href="#">登录</a>&nbsp;&nbsp;<a href="#">注册</a>
			</span>
		</div>
		
		<hr style="border: 1px solid #ff0033;" />
		
		<div class="register_content_bg">
			<div class="register_h">
				
				<div class="avatar">
  					<!-- ![](../img/register/icon_signal_fill.png) -->
  					<img src="${pageContext.request.contextPath }/resources/img/register/icon_signal_fill.png" />
				</div>
				<form id="uploadForm" enctype="multipart/form-data" method="post">
    				<input type="file" name="file" id="file" accept="img/*" class="hide"><br>个人头像
				</form>
				
			</div>
				
			<div class="register_content">
				<h3>注册</h3>
				<form method="post" action="${pageContext.request.contextPath}/register.do" enctype="multipart/form-data">
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/payment.png" /><input type="text" name="id" placeholder="请输入账户" class="ipt" />
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/icon_signal.png" />
						<input type="text" name="username" id="username" placeholder="请输入姓名" class="ipt" />
						<span id="username_msg">
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/locking.png" />
						<input type="password" name="password" id="password" placeholder="请输入密码" class="ipt" />
						<span id="password_msg">
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/locking.png" />
						<input type="password" name="repassword" id="repassword" placeholder="请确认密码" class="ipt" />
						<span id="repassword_msg">
					</p>
					<p>
						性别
						<input type="radio" name="user_sex" value="male" checked="checked" />&nbsp;男
						<input type="radio" name="user_sex" value="female" />&nbsp;女
					</p>
					<p>
						年龄<input type="number" name="user_age" min="1" max="100" class="ipt1" />
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/icon_phone.png" /><input type="tel" name="phone" placeholder="手机号" class="ipt" />
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/icon_namecard.png" />
						<input type="text" name="identity" placeholder="身份证号" class="ipt" />
					</p>
					<p>
						生日<input type="date" name="birth" class="ipt1" />
					</p>
					<p>
						<img src="${pageContext.request.contextPath }/resources/img/register/icon_GPS.png" />
						<input type="text" name="address" placeholder="地址" class="ipt" />
					</p>
					<p>				
						<input type="text" id="inp" placeholder="请输入验证码" class="ipt1" /> 
 						<input type="button" id="code" class="ipt2"/> 
						<input type="button" value="验证" id="check" class="ipt3"/> 
					</p>
					<p>
						<input type="submit" value="注册" class="btn" />
					</p>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		//是否为空
		function ifnull(txt) {
			if(txt.length == 0) {
				return true;
			}
			var $reg = /\s+/;
			return $reg.test(txt);
		}
		$("#id").blur(function() {
			if(ifnull($(this).val())) {
				$("#id_msg").html("账号不能为空!");
			}
		});
		//在id为username的元素失去焦点时进行用户名的验证
		$("#username").blur(function() {
			if(ifnull($(this).val())) {
				$("#username_msg").html("昵称不能为空!");
			} 
		});
		//在id为password的元素失去焦点时进行密码的验证
		$("#password").blur(function() {
			if(ifnull($(this).val())) {
				$("#password_msg").html("密码不能为空!");
			} else {
				var $reg = /^\w{6,10}$/;
				if(!$reg.test($("#password").val())) {
					$("#password_msg").html("密码要6-10位!");
				} 
			}
		});
		//在id为repassword的元素失去焦点时进行密码的验证
		$("#repassword").blur(function() {
			if(ifnull($(this).val())) {
				$("#repassword_msg").html("请确认密码!");
			} else {
				if($("#password").val() != $("#repassword").val()) {
					$("#repassword_msg").html("两次密码不一致!");
				} 
			}
		});
		//验证表单
		function checkForm() {
			if(ifnull($("#id").val())) {
				$("#id_msg").html("账号不能为空！");
				return false;
			}
			//验证用户名
			if(ifnull($("#username").val())) {
				$("#username_msg").html("昵称不能为空！");
				return false;
			} 
			//验证密码
			if(ifnull($("#password").val())) {
				$("#password_msg").html("密码不能为空!");
				return false;
			} else {
				var $reg = /^\w{6,10}$/;
				if(!$reg.test($("#password").val())) {
					$("#password_msg").html("密码要6-10位!");
					return false;
				}
			}
			//确认密码是否为空
			if(ifnull($("#repassword").val())) {
				$("#repassword_msg").html("请确认密码!");
				return false;
			}
			//验证两次密码是否一致
			if($("#password").val() != $("#repassword").val()) {
				$("#repassword_msg").html("两次密码不一致!");
				return false;
			}			
			return true;
		}
		
		function change(){
		    code=$("#code");
		  // 验证码组成库
		   var arrays=new Array( 
		       '1','2','3','4','5','6','7','8','9','0',
		       'a','b','c','d','e','f','g','h','i','j', 
		       'k','l','m','n','o','p','q','r','s','t', 
		       'u','v','w','x','y','z', 
		       'A','B','C','D','E','F','G','H','I','J', 
		       'K','L','M','N','O','P','Q','R','S','T', 
		       'U','V','W','X','Y','Z'        
		       ); 
		    codes='';// 重新初始化验证码
		   for(var i = 0; i<4; i++){
		   // 随机获取一个数组的下标
		   var r = parseInt(Math.random()*arrays.length);
		   codes += arrays[r];
		  }
		  // 验证码添加到input里
		     code.val(codes);
		  }
		  change();
		 code.click(change);
		 //单击验证
		  $("#check").click(function(){
		   var inputCode = $("#inp").val().toUpperCase(); //取得输入的验证码并转化为大写 
		   console.log(inputCode);
		  if(inputCode.length == 0) { //若输入的验证码长度为0
		   alert("请输入验证码！"); //则弹出请输入验证码
		  }    
		  else if(inputCode!=codes.toUpperCase()) { //若输入的验证码与产生的验证码不一致时
		   alert("验证码输入错误!请重新输入"); //则弹出验证码输入错误
		   change();//刷新验证码
		   $("#inp").val("");//清空文本框
		  }else { //输入正确时
		   alert("正确"); //弹出
		  } 
		  }); 
       
       $(document).ready(function(){
           $("input[name='file']").change(function(){
               //FormData对象，
               //可以把form中所有表单元素的name与value组成一个queryString，提交到后台。
               //在使用Ajax提交时，使用FormData对象可以减少拼接queryString的工作量
               var formData = new FormData();
               formData.append("file",$("input[name='file']")[0].files[0]);
               $.ajax({
                   url:'upload-ajax.php',
                   type:'post',
                   data: formData,
                   cache: false,
                   processData: false,
                   contentType: false,
                   success:function(data){
                       console.log(data);
                       if(data.status=="fail"){
                           alert(data.message);
                       }
           
                       if(data.status=="success"){
                           $(".avatar img").attr("src",data.url+"?"+new Date().getTime());
                       }
                   },error:function(e){
                       console.log(e);
                   }
               });
           });
       });
       
	</script>

</html>