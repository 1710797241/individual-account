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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/OtherAccount.css" />
    <script src="${pageContext.request.contextPath }/resources/js/OtherAccount.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
        })
    </script>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<div id="addBox" style="background-color: white;  width: 600px;height: 500px;margin: 15px auto;">
    <div id="form_Main">
        <form action="userModify.do" method="post">
            <table >
                
                <tr>
                    <td> 用户身份证：</td>
                    <td> <input  readonly="readonly" type="text" name="user_identity" value="${user.user_identity }" /></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" id="user_name" name="user_name" value="${user.user_name }" /><span id="acc_notice" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 性别：</td>
                    <td><input type="radio" checked="checked" <c:if test="${user.user_sex=='男' }">checked="checked"</c:if> name="user_sex"value="男">男<input type="radio" <c:if test="${user.user_sex=='女' }">checked="checked"</c:if> name="user_sex"value="女">女<span id="" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 手机号：</td>
                    <td><input type="text" id="account_email" value="${user.user_phone }" name="user_phone" /><span id="email_notice" style="display:none;"></span></td>
                </tr>
               <tr>
                <td>地址：</td>
                                    <td><input type="text" id="user_address"value="${user.user_address }" name="user_address" /><span id="email_notice" style="display:none;"></span></td>
                
            </tr>
            	 <tr>
                <td>用户等级：</td>
                                    <td><input type="text" id="account_email" value="${user.user_level }" name="user_level" /><span id="email_notice" style="display:none;"></span></td>
                
            </tr>
            <tr>
                <td>用户标签：</td>
                                    <td><input type="text" id="account_email" value="${user.user_label }" name="user_label" /><span id="email_notice" style="display:none;"></span></td>
                
            </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" id="sub" style="cursor: pointer;display: inline-block;width: 100px;height:38px;margin-left:100px;background-color: #FF0033;color: white;" value="添加"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>