<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/OtherAccount.css" />
<script type="text/javascript">
$(function(){
	
})

	
</script>

</head>
<body>
<jsp:include page="banner.jsp"></jsp:include>

<div id="addBox" style="width: 600px;height: 500px;margin: 15px auto;">
    <div id="form_Main">
        <form action="newsModify.do" method="post">
        <input type="text" name="new_code" value="${news.new_code}" style="display:none;" />
            <table >
                
                <tr>
                    <td> 标题：</td>
                    <td> <input type="text" name="news_title" value="${news.news_title}" /></td>
                </tr>
                <tr>
                    <td> 内容：</td>
                    <td><textarea rows="10" cols="26" style="resize:none"  name="news_context">${news.news_context}</textarea></td>
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