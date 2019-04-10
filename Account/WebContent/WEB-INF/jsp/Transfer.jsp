<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/Transfer.css">
    <script type="text/javascript">
        $(function () {
            var transferRet = "${transferRet}";
            if(transferRet!=""){
                alert(transferRet)
            }
        })
    </script>
</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>
<div class="wholeMain">
    <div class="main">
        <div id="form">
            <span id="operation_title">转账</span>
            <form action="transfer.do" method="post">
                请输入转入账户：<input type="text" name="transferInAccount"><br>
                请输入转出账户：<input name="transferOutAccount" value="${currAcc.account_name }" readonly="readonly"  type="text"><br>
                请输入交易密码：<input type="password" name="tradePass"><br>
                请输入转账金额：<input type="text" name="money"><br>
               <div id="btn">
                   <input id="confirm" style=" text-align: center;
                    line-height: 30px;
                    width: 50px;
                    height: 30px;
                    color: white;
                    background-color: #FF0033;"
                          type="submit" value="确定" /> <a id="cancel" href="#">取消</a>
            </form>
               </div>
        </div>
    </div>
</div>
</body>
</html>