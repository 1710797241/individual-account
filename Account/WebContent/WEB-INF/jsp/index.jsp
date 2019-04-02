<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/react.development.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/react-dom.development.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/babel.min.js"></script>
    <script type="text/javascript"src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        ul{
            text-decoration: none;
        }
        ul li{
            display: inline-block;
            margin-left: 100px;
        }
        a{
            color:white;
            text-decoration: none;
        }
        #nav{
            width: 1300px;
            background-color: #5e5e5e;
        }
        #timg{
            width: 1300px;
        }
    </style>
    <script type="text/babel">
        class MyComponetNav extends React.Component{
            render(){

                return (
                    <ul>
                        <li><a id="login" href="${pageContext.request.contextPath}/toLogin.action">登录</a> </li>
                        <li><a id="personalInof" href="${pageContext.request.contextPath}/onlyLogin/showPersonmenu.action">个人详情</a> </li>
                    </ul>


                )
            }
        }
       
        ReactDOM.render(<MyComponetNav/>,$("#nav")[0])
    </script>
</head>
<body>
<div id="nav"></div>
<div id="main"></div>
<div>
	<table width="500" border="1" >
		<c:forEach items="${userList}" var="user" varStatus="status">
			<tr><td>${status.count}</td><td>${user.name}</td><td>${user.email}</td><td>${user.phone}</td></tr>
		</c:forEach>
	</table>
</div>
</body>
</html>