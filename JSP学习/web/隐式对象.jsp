<%--
  Created by IntelliJ IDEA.
  User: 21922
  Date: 2022/12/2
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    // 在jsp中可以直接操作的9类对象
    <title>隐式对象</title>
    // request,response,pageContext,session,application,out,config,page,exception.
</head>
<body>
返回request的参数，或者信息<br>
例如：
<%= request.getMethod()+request.getRequestURL()%><br>
或者设置请求字符编码<br>
<% request.setCharacterEncoding("UTF-8");%><br>



</body>
</html>
