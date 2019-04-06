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
            $("#addAccount").click(function () {
                $("#mask").css({
                    "position":"absolute",
                    "z-index":"100",

                })
                $("#addBox").css({
                    "position":"absolute",
                    "left":"25%",
                    "top":30,
                    "display":"block",
                    "z-index":"200",

                })
                $("#close_box").click(function () {
                    $("#mask").css({
                        "display":"none"

                    })
                    $("#addBox").css({
                        "display":"none"

                    })
                })

            });
        })
    </script>
</head>
<body>
<div class="wholeMain" id="mask"></div>
<div id="addBox" style="display: none;background-color: white; border: 1px solid blueviolet; width: 600px;height: 500px;">
    <div>
        <span id="close_box" style="" >x</span>
    </div>
    <div id="form_Main">
        <form action="192.138.190.1">
            <table >
                <tr>
                    <td> 账号所属人:</td>
                    <td>
                        <select id="userIdentity" name="useIdentity">
                            <option>请选择</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> 账户号：</td>
                    <td> <input type="text" name="accountName" /></td>
                </tr>
                <tr>
                    <td> 密码：</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td> 确认密码：</td>
                    <td> <input type="password" name="repassword" /></td>
                </tr>
                <tr>
                    <td>是否为管理员：</td>
                    <td><input type="radio" name="isAdmin" id="" checked="checked" value="yes">是
                        <input type="radio" name="isAdmin" value="no" >否</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="添加"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<div class="wholeMain">
    <div class="main">
        <form action="192.166.21.2">
            <div><button type="button" id="addAccount">添加用户</button><span><label for="serachParam">账号：</label><input id="serachParam" name="serachParam" type="text"><button id="search" type="button">查询</button></span></div>

            <div style="margin-top: 10px;">
                <table class="tb_account" width="100%" id="account_show">
                    <tr>
                        <th>序号</th>
                        <th>用户身份证</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>出生年月</th>
                        <th>手机号</th>
                        <th>地址</th>
                         <th>用户等级</th>
                        <th>用户标签</th>
                        <th colspan="2">操作</th>
                    </tr>
                   	<c:forEach items="${pageInfo.list }" var="user" varStatus="status" >
                   		 <tr>
	                        <td>${status.count }</td>
	                        <td>${user.user_identity}</td>
	                        <td>${user.user_name}</td>
	                        <td>${user.user_sex}</td>
	                        <td>${user.user_birth}</td>
	                        <td>${user.user_phone}</td>
	                        <td>${user.user_address}</td>
	                         <td>${user.user_level}</td>
	                        <td>${user.user_label}</td>
	                        <td><span class="modifyBtn">修改</span></td>
	                        <td><span class="rmBtn">注销</span></td>

                   		 </tr>
                   	</c:forEach>
                </table>
            </div>
            <div class="pages">
                <ul>
                    <li>共${pageInfo.total}条记录</li>
                    <li><a href="#">首页</a></li>
                    <li></li>
                    <li><a href="#">上一页</a></li>
                    <li></li>
                    <li><a href="#">下一页</a></li>
                    <li></li>
                    <li><a href="#">当前第${pageInfo.pageNum}页/共${pageInfo.pages}页</a></li>
                </ul>
            </div>
        </form>
    </div>
</div>

</body>
</html>