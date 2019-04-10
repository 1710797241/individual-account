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
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain">
    <div class="main" >
        <form action="otherAccountModify.do" method="post">

                        <table style="width: 300px;margin: auto auto;">
                            <tr style="display: none;"><td colspan="2"><input type="text" value="${account.account_code}" name="account_code" ></td></tr>
                            <tr>
                                <td> 账号所属人:</td>
                                <td>
						<select id="user_identity" name="user_identity">
                            <c:forEach items="${userList}" var="user" varStatus="status">

                            	<option id="${status.index}" 
                            	<c:if test="${account.user_identity== user.user_identity}">selected="selected"</c:if>
                            	 value="${user.user_identity }">${user.user_identity}</option>
                            </c:forEach>
                        </select>

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
                    		<td> 邮箱：</td>
                    			<td><input type="text" id="account_email" name="account_email" value="${account.account_email}" /><span id="email_notice" style="display:none;"></span></td>
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