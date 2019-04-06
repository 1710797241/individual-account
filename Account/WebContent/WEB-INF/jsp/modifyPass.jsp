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
</head>
<body>
<div class="wholeMain">
    <div class="main" id="change">
        <div class="changeItem" >
            <form action="modifyPass.do" method="post">
                <input type="text" style="display: none;" name="account_code" value="${account.account_code}">
                <table style="width: 300px;height:185px;margin: auto auto;">
                    <tr >
                        <td colspan="2">修改密码</td>
                    </tr>
                    <tr >
                        <td>新密码:</td>
                        <td> <input type="password" name="account_password"  ></td>
                    </tr>
                    <tr>
                        <td> 确认密码:</td>
                        <td> <input type="password" name="repass" ></td>
                    </tr>
                    <tr style="margin-top:5px; ">
                        <td colspan="2"><input type="submit" value="确认修改"></td>

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