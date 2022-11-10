package servlet; /**
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

public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("s1的get请求");
        // 新建对象，获取到传输过来的servlecontext
        ServletContext sc=getServletContext();
        // 根据key获取到值
        String data=(String)sc.getAttribute("data");
        // 将其相应回
        resp.getOutputStream().write(data.getBytes());
        System.out.println(data);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}