<%--
  Created by IntelliJ IDEA.
  User: 21922
  Date: 2022/12/1
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>指令标签</title>
</head>
<body>
dCMGr7sF
// page指令,注意只能指定一次
<%@ page import="java.util.Date","java.util.*" %>
<%@ page contentType="text/html; ISO-8859-1" %>
// 指定本jsp所使用的脚本语言，目前只能用java，所以没卵用
<%@ page language="java" %>
// 是否需要使用内置的session对象
<%@ page session="true" %>

// jsp中有个内置对象out,利用out可以向网页打印内容，而这部分的内容大小由buffer控制，如设置为none，则out输出将失效
<%@ page buffer="8kb" %>

// out的缓冲区填满后，是否自动刷新
<%@ page autoFlush="true" %>

// 设定本jsp为错误页，发生错误自动跳转本页
<%@ page isErrorPage="true" %>
</body>
</html>
