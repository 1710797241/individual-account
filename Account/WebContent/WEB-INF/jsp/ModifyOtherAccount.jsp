<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/ModifyOtherAccount.css" />
    <script src="${pageContext.request.contextPath }/resources/js/OtherAccount.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {

            
            var addRet = "${addRet}";
            if(addRet !=""){
                alert(addRet);
            }
        })
    </script>
</head>
<body>


<div class="wholeMain">
    <div class="main" >
        <form action="otherAccountModify.do" method="POST">

                        <table style="width: 300px;margin: auto auto;">
                            <input type="text" value="${account.account_code}" name="account_code" style="display: none;">
                            <tr>
                                <td> 账号所属人:</td>
                                <td>
                                    <input type="text" id="user_identity" name="user_identity" value="${account.user_identity}">


                                </td>
                            </tr>
                            <tr>
                                <td> 账户号：</td>
                                <td> <input type="text" name="account_name" value="${account.account_name}" /></td>
                            </tr>
                            <tr>
                                <td> 密码：</td>
                                <td><input type="password" name="account_password" value="${account.account_password}"/></td>
                            </tr>
                            <tr>
                                <td> 交易密码：</td>
                                <td><input type="password" name="trade_password" value="${account.trade_password}" /></td>
                            </tr>
                            <tr>
                                <td>是否为管理员：</td>
                                <td><input type="radio" name="is_admin"  <c:if test="${account.is_admin == 'yes'}"> checked="checked" </c:if> value="yes">是
                                    <input type="radio" name="is_admin"<c:if test="${account.is_admin == 'no'}"> checked="checked" </c:if> value="no" >否</td>
                            </tr>

                            <tr>
                                <td colspan="2">
                                    <input type="submit" style="cursor: pointer;display: inline-block;width: 160px;height:38px;background-color: #FF0033;color: white;" value="修改"/>
                                </td>
                            </tr>
                        </table>
        </form>
    </div>
</div>

</body>
</html>