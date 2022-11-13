import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/12 16:24
 *
 *     通过session在服务器端保留住客户的密码和姓名，而不进行网络传输
 */

public class SessionServlet extends HttpServlet {

    // 客户端请求，生成session，session编号+cookie返回客户端

    // 根据客户端的cookie，找保留在本地的session.

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doGet方法");
        // 判断是否有session，且合法？
        HttpSession session=req.getSession();
        String username= "";username=(String) session.getAttribute("username");
        String password="";password=(String) session.getAttribute("password");

        // 判断是否有session
        if (username!=null&&password!=null) {
            // 判断是否合法
            if (username.equals("admin") && password.equals("123")) {
                // 说明是合法，且之前登录过

                // 获取到sessionID,并且返回到网页
                resp.getWriter().print(session.getId());
                //resp.sendRedirect("successful.html");
                System.out.println("曾经登陆过的session用户");

            } else {
                // 返回空目录
                resp.sendRedirect("index.html");
            }
        }
        else
        {
            resp.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 做一个session，返回
        if (req.getParameter("username").equals("admin")&&req.getParameter("password").equals("123"))
        {
            // 注意：要先从客户那边拿到session，才可进行添加数据
            HttpSession session=req.getSession();
            session.setAttribute("username","admin");
            session.setAttribute("password","123");
            resp.sendRedirect("successful.html");
        }
        else
        {
            resp.getWriter().print("Sorry，bad user");
        }

    }
}
