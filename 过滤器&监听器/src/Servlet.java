import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/14 18:34
 */
public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service 方法");
        req.getRequestDispatcher("/index.html").forward(req,resp);
    }
}
