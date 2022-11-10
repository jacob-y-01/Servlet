import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/2 16:14
 */
public class servletTest1 extends HttpServlet
{
    // 初始化servlet对象，容器创建servlet对象后会调用该方法
    public void init() throws ServletException {
        System.out.println("servlet1的init方法");
        super.init();
    }


    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("返回用户访问的目录"+req.getContextPath());
        System.out.println("返回http请求中的所有cookie"+req.getCookies());
        System.out.println("返回请求头部的特定项目,例如 Content-Type"+req.getHeader("Content-Type"));
        System.out.println("返回enumeration 对象，该对象包含http头部全部项目名"+req.getHeaderNames().toString());
        System.out.println("返回请求头部的第一行中的url"+req.getRequestURL());
        System.out.println("返回http中的查询字段，即？后所跟随的内容"+req.getQueryString());
        System.out.println("返回http请求方法，比如post，get"+req.getMethod());

        String result = "您好，欢迎访问 servlet1！";
        //返回结果
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        // 获取PrintWriter对象
        PrintWriter out = resp.getWriter();
        out.print(result);
        // 释放PrintWriter对象
        out.flush();
        out.close();




        //******************************
        //   HttpServletResponse对象
        //******************************
        // 在响应消息头中，加入一条内容
        resp.addHeader("HostName","我的主机");

        // 向用户发送一个特定的错误号，错误，像404这种
        resp.sendError(5201314,"抱歉你被逮捕了，罪名为偷心盗贼");

        // 设置响应头第一行内容
        //resp.setHeader("adsdas","一般不要乱用，第一行内容很重要");

        // 设置状态码
        resp.setStatus(5201314);

        // 设置cookie
        //resp.addCookie(new Cookie());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get1");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post2");
        super.doPost(req, resp);
    }

    public void destroy() {
        super.destroy();
    }
}


