<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
		
		<style>
		.four {
			width: 1000px;
			height: 1000px;
			margin: 0 auto;
		}	
		.nav {
			height: 100px;
			width: 995px;
			border-bottom: 1px solid blue;
		}
		.nav a{
			padding-left: 30px;
			text-decoration: none;
		}
		.nav h1 {
			height: 40px;
			margin: 0px;
			padding-top: 25px;
			padding-left: 25px;
		}
		.one {
			height: 50px;
			width: 995px;
			border-top: 3px solid #ccc;
			border-left: 5px solid #ccc;

			border-bottom: 3px solid #ccc;

			border-bottom: 3px solid #ccc;
			background-color: white;
			text-align: center;
		}
		/*.one a{
			height: 50px;
			line-height: 50px;
			text-decoration: none;
			text-align: center;
			display: inline-block;
			padding: 0px 58px;
			font-size: 16px;
			border-right: 3px solid #ccc;
		}*/
		.two {
			width: 995px;
			height: 600px;
			background-image: url(img/234.jpg);
			border-top: 1px solid #ccc;
		}
		.rig {
			width: 400px;
			margin-left:700px ;
			padding-left: 25px;
			padding-right: 6px;
			padding-bottom: 3px;
			display: inline;
		}
		.three {
			height: 300px;
			width: 300px;
			background-color: white;
			margin-left: 650px;
			margin-bottom: 300px;
			border: 2px solid #ccc;
			
		}
		.form {
		
			border: 2px dotted #AAAAAA;
			
		}
		.three p {
				text-indent: 1em;
			text-align: center;
		}
		
		</style>
		<script type="text/javascript">
			$(function(){
				$("#changeYan").click(function(){
							$("#yan").attr("src","yan.do?ran="+Math.random())
						
				})
				
				var loginRet = "${loginRet}";
				if(loginRet!=""){
					alert(loginRet)
				}
			})
			
		</script>
	</head>
	<body>
		<div class="four">
			
		
		<div class="nav">
			<h1>个人资金账户管理系统</h1>
			<div class="rig">
			<a href="#">登陆</a>
			<a href="#">注册</a>
			</div>
		</div>
		
		<div class="two">
			<br/>
			<br/>
			<br/>
			<div class="three">
			<form action="login.do" method="post">
				<br />
				<p><img src="${pageContext.request.contextPath }/resources/img/icon_signal.png"/>
				<label for="user">账户：</label> 
				<input name="account_name"  type="text"><br /></p>
				<p><img src="${pageContext.request.contextPath }/resources/img/locking.png"/>
				<label for="password">密码：</label>
				<input name="account_password" type="password"><br /></p>
				<p><img id="yan" src="yan.do" alt="" />
				<input type="button"value="看不清，换一换" id="changeYan"/>
				</p>
				<p>输入验证码：
				<input name="vtcode" type="text"/></p>
				<p><input type="submit" id="sbutton" value="登陆"/></p>
				<p><a href="#">忘记密码？</a>
				<a href="#">没有账户？立即注册</a>
				</p>
			</form>
			</div>
		</div>
		</div>
	</body>
</html>
