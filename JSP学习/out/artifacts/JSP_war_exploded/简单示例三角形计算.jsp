<%--
  Created by IntelliJ IDEA.
  User: 21922
  Date: 2022/12/1
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!可以如此导包>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>三角形计算</title>
</head>
<body>
<p>输入三角形三边长</p><br>

<form action="简单示例三角形计算.jsp" method="post" name=form>
    <input type="text" name="in" id="">
    <input type="submit" value="提交" name="submit">
</form>

<!注意区别；%!只能声明变量，%才是彻底的代码,注意这里面的声明是静态的>
<%!
    double a[]=new double[3];
    String answer=null;

    // 声明方法和变量
    int num=0;
    synchronized void count()
    {
        num++;
    }
%>

<%
    count();
    String s=request.getParameter("in");
    // 可以根据s字符串来分析其中的数据，然后来计算三角形
    if (s=="")
    {
        answer="<br>"+"请输入数据";
    }
    else
    {
        answer"用户所输入的内容"+s;
    }
    s="你是第"+num+"个访问本网站者";
%>

<!两种方式反馈页面,只要是个值，都可以如此打印>
<p><% out.print(answer);%></p>
<p><%=s%></p>


// 设置出错页，出错后自动跳转
<%@ page errorPage="指令标签.jsp" %>
</body>
</html>
