import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/10 18:20
 */
public class LoginCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("service 请求");
        // 简单过程就是，有cookie，返回你一个记住密码的网页，没cookie，返回一个没写密码的网页
        // 之前是判断用户名密码，现在是判断cookie，再决定是否填充用户名和密码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        if (cookies!=null)
        {
            System.out.println("有cookie");
            // 检查cookie，直接响应需要的页面
            String username="";
            String password="";

            for (int i=0;i<cookies.length;i++)
            {

                // 从cookie中提取信息，判断是否是合法用户cookieName，cookiePwd
                if (cookies[i].getName().equals("username"))
                {
                    username=cookies[i].getValue();
                }
                if (cookies[i].getName().equals("password"))
                {
                    password=cookies[i].getValue();
                }
            }
            System.out.println(username+password);
            if(password.equals("123")&&username.equals("admin")) {
                resp.getWriter().print("你好！欢迎" + username + "密码" + password);
            }
            else
            {
                resp.sendRedirect("index.html");
            }
        }
        else {
            System.out.println("没cookie");
            // 响应空白登录页面
            resp.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用户提交表单，判断是否成功，成功，发cookie
        System.out.println("post 请求"+req.getParameter("username"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");


        if (req.getParameter("username").equals("admin")&&req.getParameter("password").equals("123")) {
            Cookie Cusername=new Cookie("username",req.getParameter("username"));
            Cookie Cpassword=new Cookie("password",req.getParameter("password"));
            resp.addCookie(Cpassword);
            resp.addCookie(Cusername);
            resp.sendRedirect("successful.html");
        }
        else
        {
            resp.getWriter().print("登录失败！");
        }
    }

}
