<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/modifyPass.css">
	<script type="text/javascript">
	$(function(){
		
		$("#repass").blur(function(){
			var comfirmType= "${comfirmType }"
				if(comfirmType=="trade_pass"){
					var account_password = $("#account_password").val();
					var repassVal = $("#repass").val();
					if(account_password!=repassVal||account_password.length!=6||repassVal.length!=6){
						$("#notice").text("请输入6位数交易密码");
						$("#notice").css("display","block")
						$("#sub").attr("disabled",true);
						
					}else{
						$("#notice").text("");
						$("#notice").css("display","none");
						$("#sub").attr("disabled",false);
					}
				}
			if(comfirmType=="account_pass"){
				var account_password = $("#account_password").val();
				var repassVal = $("#repass").val();
				if(account_password!=repassVal||account_password.length<6||repassVal.length<6||account_password.length>20||repassVal.length>20){
					$("#notice").text("请输入6-20位数登录密码");
					$("#notice").css("display","block")
					$("#sub").attr("disabled",true);
					
				}else{
					$("#notice").text("");
					$("#notice").css("display","none");
					$("#sub").attr("disabled",false);
				}
			}
			
		})
		
		
	})
	
	</script>

</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain">
    <div class="main" id="change">
        <div class="changeItem" >
            <form action="modifyPass.do" method="post">
                <input style="display:none;" type="text" name="comfirmType" value="${comfirmType }"/>
                <table style="width: 300px;height:185px;margin: auto auto;">
                    <tr >
                        <td colspan="2">修改密码</td>
                    </tr>
                    <tr >
                        <td>新密码:</td>
                        <td> <input type="password" id="account_password" name="account_password"  ></td>
                    </tr>
                    <tr>
                        <td> 确认密码:</td>
                        <td> <input type="password" id="repass" name="repass" ><span style="display:none;" id="notice"></span></td>
                    </tr>
                    <tr style="margin-top:5px; ">
                        <td colspan="2"><input id="sub" style="cursor:pointer;" type="submit" value="确认修改"></td>

                    </tr>
                </table>
               <br>
              <br>

            </form>
        </div>

    </div>

</div>

</body>
</html>