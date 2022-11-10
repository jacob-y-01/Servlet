package servlet;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/10/31 17:07
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("s2的get请求");
        // 新建 servlecontext对象
        ServletContext sc=getServletContext();
        // 设置共享数据，主键，值
        sc.setAttribute("data","123456");
        // 返回
        resp.getOutputStream().write("OK".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
