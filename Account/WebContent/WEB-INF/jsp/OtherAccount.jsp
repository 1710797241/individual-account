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
            $("#user_identity").change(function(){
            	var user_id = $("#user_identity option:selected").attr("id");
               if(user_id>=0){
                   $("#user_name").css('display','block');
               }else{
                   $("#user_name").css('display','none');
               }
                var nameOptions = $("#user_name option");

                for(var i = 0;i<nameOptions.length;i++){
                    if(i==user_id){
                        $(nameOptions[i]).attr("selected",true);
                    }else{
                        $(nameOptions[i]).attr("selected",false);
                    }

                }
            })
            
            var addRet = "${addRet}";
            if(addRet !=""){
                alert(addRet);
            }
        })
    </script>
</head>
<body>
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
                            <option id="-1">请选择</option>
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
                    <td><input type="password" name="account_password" /></td>
                </tr>
                <tr>
                    <td> 交易密码：</td>
                    <td><input type="password" name="trade_password" /></td>
                </tr>
                <tr>
                <td>是否为管理员：</td>
                <td><input type="radio" name="is_admin" id="" checked="checked" value="yes">是
                    <input type="radio" name="is_admin" value="no" >否</td>
            </tr>
                <tr>
                    <td>是否被加锁：</td>
                    <td><input type="radio" name="delete_status" id="" checked="checked" value="yes">是
                        <input type="radio" name="delete_status" value="no" >否</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" style="cursor: pointer;display: inline-block;width: 100px;background-color: #FF0033;color: white;" value="添加"/>
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
                    <input id="serachParam"  name="account" type="text">

                </span>
                <span>
                    <label for="serachParam1">用户：</label>
                    <input id="serachParam1" name="usercode" type="text">
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
                        <th>户主</th>
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
	                        <td>${account.is_admin}</td>
	                        <td><span class="modifyBtn"><a href="otherAccountShowBeforeModify.do?account_code=${account.account_code}">修改</a> </span></td>
                             <td><span class="rmBtn"><a href="otherAccountDel.do?account_code=${account.account_code}">注销</a></span></td>

                   		 </tr>
                   	</c:forEach>
                </table>
            </div>
            <div class="pages">
                <ul>
                    <li>共${pageInfo.total }条记录</li>
                    <li><a href="#">首页</a></li>
                    <li></li>
                    <li><a href="#">上一页</a></li>
                    <li></li>
                    <li><a href="#">下一页</a></li>
                    <li></li>
                    <li><a href="#">当前第${pageInfo.pageNum }页/共${pageInfo.pages }页</a></li>
                </ul>
            </div>
        </form>
    </div>
</div>

</body>
</html>