<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/OtherAccount.css" />

<link href="${pageContext.request.contextPath }/resources/css/zixun.css" rel="stylesheet" type="text/css" />
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
            var modRet = "${modRet}";
        	
        	if(modRet!=""){
        		
        		alert(modRet)
        	}
            var delRet = "${delRet}";
            if(delRet !=""){
                alert(delRet);
            }
            
            
           
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
        <form action="newsAdd.do" method="post">
            <table >
                
                <tr>
                    <td> 标题：</td>
                    <td> <input type="text" name="news_title" /></td>
                </tr>
                <tr>
                    <td> 内容：</td>
                    <td><textarea rows="10" cols="26" style="resize:none" name="news_context"></textarea></td>
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
	<div class="zixun_head main" style="margin-top:10px;">
	<div class="main">
        <form action="newsSearch.do" method="get">
            <div>
                <button type="button" id="addAccount">添加新闻</button>
                <span>
                    <label for="serachParam">新闻编号：</label>
                    <input id="serachParam" value="${newsCode }" name="newsCode" type="text">

                </span>
                <span>
                    <label for="serachParam1">发布人：</label>
                    <input id="serachParam1"  value="${publisher_name }" name="publisher_name" type="text">
                    <button id="search" class="search" style="cursor: pointer;" type="submit">查询</button>
                </span>

            </div>
           </form>
	</div>
	<div class="zixun_content">
	<table width="800" border="0">
	<tr>
	<th>序号</th>
	<th>新闻编号</th>
	<th>标题</th>
	<th>内容</th>
	<th>发布人</th>
	<th>发布时间</th>
	<th>操作</th>
	</tr>
	<c:forEach items="${pageInfo.list }" var="news" varStatus="status">
	<tr style="witdh:100px;height:38px;">
	<td>${status.count}</td>
	<td>${news.new_code }</td>
	<td>${news.news_title }</td>
	<td style="witdh:100px;height:38px;overflow:hidden;">${news.news_context }</td>
	<td>${news.news_publisher }</td>
	<td>
	<fmt:formatDate value="${news.news_datetime }" pattern="yyyy-MM-dd HH:mm:ss"/> 
	</td>
	<td>
	<a href="newsModifyShow.do?news_code=${news.new_code }">修改</a>&nbsp;&nbsp;<a href="newsDel.do?news_code=${news.new_code }">删除</a>
	</td>
	</tr>
	
	</c:forEach>
	
	</table>
	</div>
	 <div class="pages">
                <ul>
                    <li>共${pageInfo.total }条记录</li>
                    <li><a href="newsSearch.do?pageNum=1&accountName=${accountName}&usercode=${usercode}">首页</a></li>
                    <li></li>
                    <li><a href="newsSearch.do?pageNum=${pageInfo.pageNum==1?1:pageInfo.pageNum-1 }&accountName=${accountName}&usercode=${usercode}">上一页</a></li>
                    <li></li>
                    <li><a href="newsSearch.do?pageNum=${pageInfo.pageNum<pageInfo.pages?pageInfo.pageNum+1:pageInfo.pageNum }&accountName=${accountName}&usercode=${usercode}">下一页</a></li>
                    <li></li>
                    <li><a href="javascript:void(0)">当前第${pageInfo.pageNum }页/共${pageInfo.pages }页</a></li>
                </ul>
            </div>
	</div>
</div>
</body>
</html>