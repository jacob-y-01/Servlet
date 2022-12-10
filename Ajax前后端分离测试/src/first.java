import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/12/9 13:31
 */

// 根据用户的动作去请求servlet，再根据数据，更改页面，而不需要二次请求刷新页面，大大减少了客户和服务器的负担
public class first extends HttpServlet {


    public void PrintAllResponse(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求行的相关信息

        System.out.print(request.getMethod());
        System.out.print(request.getLocalAddr());
        System.out.print(request.getServletPath());
        System.out.print("?"+request.getQueryString());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintAllResponse(req,resp);
        //resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();
        out.println("ok");
        out.flush();
        out.close();
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
