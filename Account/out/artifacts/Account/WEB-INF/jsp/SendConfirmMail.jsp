<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Base.css">

</head>
<body>
<div class="wholeMain">
    <div class="main" id="change">
        <div class="changeItem">
            <form action="sendEmail.do" method="post">
                <span class="title">邮箱验证：</span>
                <input type="text" name="email" value="${email}"><br>
                <input type="submit" style="cursor: pointer"  value="验证"><br>
            </form>
        </div>

    </div>

</div>

</body>
</html>