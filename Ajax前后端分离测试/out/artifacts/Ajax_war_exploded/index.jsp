<%--
  Created by IntelliJ IDEA.
  User: 21922
  Date: 2022/12/9
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax测试学习</title>
  </head>
  <body>
  <form action="">
    username:<input type="text" name="username" onblur="send(this)"/>&nbsp;<br>
    <span id="info"></span><br>
    passowrd:<input type="password" name="password">
  </form>
  </body>
</html>
<script language="JavaScript">
    var xhr
    // 根据不同的浏览器创建不同的XMLRequest对象。
    function createXHR() {
        if (window.ActiveXObject)
        {
            xhr=new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if (window.XMLHttpRequest)
        {
            xhr=new XMLHttpRequest();
        }
        else
        {
            alert("无法创建xhr对象")
        }
        return xhr;
    }
    function send()
    {
        // 创建对象
        var xhr=createXHR();
        var username="jack";

        // 向服务器请求数据
        xhr.open("get","/first?username="+username,false);
        // 发送
        xhr.send(null);
        // 监听服务端的返回
        xhr.onreadystatechange=getStatusCallback();
    }


    function getStatusCallback()
    {
            // 接收到响应
            if (xhr.readyState==4)
            {
                if(xhr.status==200) {
                    // 响应码正常
                    // 显示服务器返回的内容
                    alert(xhr.responseText)
                    document.getElementById("info").innerHTML = xhr.responseText;

                }
            }
    }

</script>
