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
            
            
            
            
            $("#account_password").blur(function(){
            	var account_pass = $("#account_password").val();
            	if(account_pass.length<6||account_pass.length>20){
            		$("#acc_notice").text("请输入6-20为登录密码");
            		$("#acc_notice").css("display","block");
            		$("#sub").attr("disabled",true);
            		
            		
            	}else{
            		$("#acc_notice").text("");
            		$("#acc_notice").css("display","none");
            		$("#sub").attr("disabled",false);
            	}
            
            	
            })
            
             $("#trade_password").blur(function(){
            	 var trade_password = $("#trade_password").val();
            	 alert(trade_password)
            	if(trade_password.length!=6){
            		
            		$("#trade_notice").text("请输入6位交易密码");
            		$("#trade_notice").css("display","block");
            		$("#sub").attr("disabled",true);
            		
            		
            	}else{
            		$("#acc_notice").text("");
            		$("#acc_notice").css("display","none");
            		$("#sub").attr("disabled",false);
            	}
            
            	
            })
        })
    </script>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain" id="mask"></div>
<div id="addBox" style="display: none;width: 600px;height: 500px;">
    <div>
        <span id="close_box" style="" >x</span>
    </div>
    <div id="form_Main">
        <form action="otherAccountAdd.do" method="post">
            <table >
                <tr>
                    <td> 账号所属人:</td>
                    <td>
                        <select id="user_identity" name="user_identity">
                            <c:forEach items="${userList}" var="user" varStatus="status">

                            	<option id="${status.index}" value="${user.user_identity }">${user.user_identity}</option>
                            </c:forEach>
                        </select>
                        <select style="display: none" disabled="disabled" >
                        <c:forEach items="${userList}" var="user" varStatus="status">

                            	<option  value="${user.user_name }">${user.user_name}</option>
                            </c:forEach>
                           </select>
                    </td>
                </tr>
                <tr>
                    <td> 账户号：</td>
                    <td> <input type="text" name="account_name" /></td>
                </tr>
                <tr>
                    <td> 密码：</td>
                    <td><input type="password" id="account_password" name="account_password" /><span id="acc_notice" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 交易密码：</td>
                    <td><input type="password" id="trade_password" name="trade_password" /><span id="trade_notice" style="display:none;"></span></td>
                </tr>
                <tr>
                    <td> 邮箱：</td>
                    <td><input type="text" id="account_email" name="account_email" /><span id="email_notice" style="display:none;"></span></td>
                </tr>
                <tr>
                <td>是否为管理员：</td>
                <td><input type="radio" style="width:10px;height:10px;" name="is_admin"   value="yes">是
                    <input type="radio" style="width:10px;height:10px;" name="is_admin"checked="checked" value="no" >否</td>
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
        <form action="otherAccountSearch.do" method="get">
            <div>
                <button type="button" id="addAccount">添加账号</button>
                <span>
                    <label for="serachParam">账号：</label>
                    <input id="serachParam" value="${accountName }" name="accountName" type="text">

                </span>
                <span>
                    <label for="serachParam1">用户身份证：</label>
                    <input id="serachParam1"  value="${usercode }" name="usercode" type="text">
                    <button id="search" class="search" style="cursor: pointer;" type="submit">查询</button>
                </span>

            </div>

            <div style="margin-top: 10px;">
                <table class="tb_account" width="100%" id="account_show">
                    <tr>
                        <th>序号</th>
                        <th>账号</th>
                        <th>账号余额</th>
                        <th>账号积分</th>
                        <th>户主身份证</th>
                        <th>户主姓名</th>
                        <th>邮箱</th>
                        <th>是否是管理员</th>
                        <th colspan="2">操作</th>
                    </tr>
                   	<c:forEach items="${pageInfo.list }" var="account" varStatus="status" >
                   		 <tr>
	                        <td>${status.count }</td>
	                        <td>${account.account_name}</td>
	                        <td>${account.account_balance}</td>
	                        <td>${account.account_score}</td>
	                        <td>${account.user_identity}</td>
	                        <td>${account.user_name}</td>
	                        <td>${account.account_email}</td>
	                        <td>${account.is_admin}</td>
	                        <td><a class="modifyBtn" href="otherAccountShowBeforeModify.do?account_code=${account.account_code}">修改</a> </td>
                             <td><a class="rmBtn" href="otherAccountDel.do?account_code=${account.account_code}">注销</a></td>

                   		 </tr>
                   	</c:forEach>
                </table>
            </div>
            <div class="pages">
                <ul>
                    <li>共${pageInfo.total }条记录</li>
                    <li><a href="otherAccountSearch.do?pageNum=1&accountName=${accountName}&usercode=${usercode}">首页</a></li>
                    <li></li>
                    <li><a href="otherAccountSearch.do?pageNum=${pageInfo.pageNum==1?1:pageInfo.pageNum-1 }&accountName=${accountName}&usercode=${usercode}">上一页</a></li>
                    <li></li>
                    <li><a href="otherAccountSearch.do?pageNum=${pageInfo.pageNum<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pageNum }&accountName=${accountName}&usercode=${usercode}">下一页</a></li>
                    <li></li>
                    <li><a href="javascript:void(0)">当前第${pageInfo.pageNum }页/共${pageInfo.pages }页</a></li>
                </ul>
            </div>
        </form>
    </div>
</div>

</body>
</html>