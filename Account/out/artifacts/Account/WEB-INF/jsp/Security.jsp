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
        })
    </script>
</head>
<body>
<div class="wholeMain">
    <div class="main" id="change">
        <div class="changeItem">
            <span class="fixleft">邮箱：</span>
            <span class="content">18888@qq.com</span>
            <span class="fixright"><span>已绑定</span><a href="#">修改</a></span>
        </div>
        <div class="changeItem">
            <span class="fixleft">密码：</span>
            <span class="content"><input type="password" disabled="disabled"></span>
            <span>密码强度：<span id="passLevel" style="display: inline-block;width: 16px;height: 14px;background-color: gold"></span></span><span class="fixright"><a href="securityConfirm.do">修改</a></span>
        </div>
        <div class="changeItem">
            <span class="fixleft">交易密码：</span>
            <span class="content"><input type="password" disabled="disabled"></span>
            <span><span class="fixright"><a href="">修改</a></span></span>

        </div>
    </div>

</div>

</body>
</html>