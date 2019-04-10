<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Security.css">
    <script type="text/javascript">
        $(function () {
            var mailMsg = "${mailMsg}";
            if(mailMsg != ""){
                alert(mailMsg);

            }
            var modifyResult = "${modifyResult}";
            if(modifyResult != ""){
                alert(modifyResult);

            }
        })
    </script>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain">
    <div class="main" id="change">
        <div class="changeItem">
            <span class="fixleft">邮箱：</span>
            <span class="content">${currAcc.account_email }</span>
            <span class="fixright"><span>已绑定</span></span>
        </div>
        <div class="changeItem">
            <span class="fixleft">密码：</span>
            <span class="content"><input type="password" value="${currAcc.account_password }" disabled="disabled"></span>
            <span class="fixright"><a href="securityConfirm.do?comfirmType=account_pass">修改</a></span>
        </div>
        <div class="changeItem">
            <span class="fixleft">交易密码：</span>
            <span class="content"><input type="password" value="${currAcc.trade_password }" disabled="disabled"></span>
            <span><span class="fixright"><a href="securityConfirm.do?comfirmType=trade_pass">修改</a></span></span>

        </div>
    </div>

</div>

</body>
</html>