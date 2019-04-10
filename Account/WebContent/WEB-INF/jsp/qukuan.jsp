<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/resources/css/qukuan.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function(){
		var withdrawRet = "${withdrawRet}";
		if(withdrawRet!=""){
			alert(withdrawRet)
		}
		
	})
</script>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>

	<div class="qukuan_head">
			<h2>个人资金账户管理系统</h2>
			<img />
		</div>
		
		<hr style="border: 1px solid #ff0033;" />
		
		<div class="qukuan_content_bg">
			<div class="qukuan_content">
				<h3>取款</h3>
				<form action="withdraw.do" method="post">
					<p>
					请输入取款账户：
					<input type="text" name="account_name" />
					</p>
					<p>
					请输入交易密码：<input type="password" name="tradePass" />
					</p>
					<p>
					请输入取款金额：<input type="number" min="100" max="1000" step="100" name="money" />
					</p>
					<div class="button">
						<input type="submit" value="确定" class="btn" />
						<input type="button" value="取消" class="btn" />
					</div>
				</form>
			</div>
		</div>

</body>
</html>