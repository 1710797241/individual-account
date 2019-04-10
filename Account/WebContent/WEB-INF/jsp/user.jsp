<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
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
        	
        	 var addRet = "${addRet}";
             if(addRet !=""){
                 alert(addRet);
             }
             var modifyRet = "${modifyRet}";
             if(modifyRet !=""){
                 alert(modifyRet);
             }
             var delRet = "${delRet}";
             if(delRet !=""){
                 alert(delRet);
             }
        	
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
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain" id="mask"></div>
<div id="addBox" style="display: none;background-color: white; border: 1px solid blueviolet; width: 600px;height: 500px;">
    <div>
        <span id="close_box" style="" >x</span>
    </div>
    <div id="form_Main">
        <form action="userAdd.do" method="post">
            <table >
                
                <tr>
                    <td> 用户身份证：</td>
                    <td> <input type="text" name="user_identity" /></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" id="user_name" name="account_password" /><span id="acc_notice" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 性别：</td>
                    <td><input type="radio" name="user_sex"value="男">男<input type="radio" name="user_sex"value="女">女<span id="" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 手机号：</td>
                    <td><input type="text" id="account_email" name="user_phone" /><span id="email_notice" style="display:none;"></span></td>
                </tr>
               <tr>
                <td>地址：</td>
                                    <td><input type="text" id="user_address" name="user_address" /><span id="email_notice" style="display:none;"></span></td>
                
            </tr>
            	 <tr>
                <td>用户等级：</td>
                                    <td><input type="text" id="account_email" name="user_level" /><span id="email_notice" style="display:none;"></span></td>
                
            </tr>
            <tr>
                <td>用户标签：</td>
                                    <td><input type="text" id="account_email" name="user_label" /><span id="email_notice" style="display:none;"></span></td>
                
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

<div class="wholeMain">
    <div class="main">
        <form action="userShow.do" method="get">
            <div><button type="button" id="addAccount">添加用户</button><span><label for="serachParam">姓名：</label><input id="serachParam" value="${user_name }" name="user_name" type="text">
                    <button id="search" class="search" style="cursor: pointer;" type="submit">查询</button>
            </span></div>

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
	                        <td>
	                        <fmt:formatDate value="${user.user_birth}" pattern="yyyy-MM-dd" />
	                        </td>
	                        <td>${user.user_phone}</td>
	                        <td>${user.user_address}</td>
	                         <td>${user.user_level}</td>
	                        <td>${user.user_label}</td>
	                      <td><a class="modifyBtn" href="userModifyShow.do?user_identity=${user.user_identity}">修改</a> </td>
                             <td><a class="rmBtn" href="userDel.do?user_identity=${user.user_identity}">删除</a></td>


                   		 </tr>
                   	</c:forEach>
                </table>
            </div>
            <div class="pages">
                <ul>
                    <li>共${pageInfo.total }条记录</li>
                    <li><a href="userShow.do?pageNum=1&user_name=${user_name}">首页</a></li>
                    <li></li>
                    <li><a href="userShow.do?pageNum=${pageInfo.pageNum==1?1:pageInfo.pageNum-1 }&user_name=${user_name}">上一页</a></li>
                    <li></li>
                    <li><a href="userShow.do?pageNum=${pageInfo.pageNum<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pageNum }&user_name=${user_name}">下一页</a></li>
                    <li></li>
                    <li><a href="javascript:void(0)">当前第${pageInfo.pageNum }页/共${pageInfo.pages }页</a></li>
                </ul>
            </div>
        </form>
    </div>
</div>

</body>
</html>