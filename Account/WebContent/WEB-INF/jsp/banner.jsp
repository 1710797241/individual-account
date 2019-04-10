<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/banner.css">
</head>
<body>
<a href="logout.do">退出</a>
<div id="banner">
    <div class="ban_child">
            <a href="#">首页</a>
    </div>
    <div class="ban_child">
            <a href="otherAccountSearch.do">账户管理</a>
    </div>
    <div class="ban_child">
            <a  href="javascript:void(0)">个人账户</a>
            <ul>
                <li><a href="transferIndex.do">转账</a></li>
                <li><a href="withdrawIndex.do">取款</a></li>
                <li><a href="#">存款</a></li>
            </ul>
    </div>
    <div class="ban_child">
            <a href="newsSearch.do">资讯</a>
    </div>
    <div class="ban_child">
            <a href="securityIndex.do">安全中心</a>
    </div>
    <div class="ban_child">
            <a href="userShow.do">信息管理</a>
            
    </div>
    
</div>
</body>
</html>