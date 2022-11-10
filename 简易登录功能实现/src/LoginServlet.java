import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/2 18:57
 */
public class LoginServlet extends HttpServlet {

    private boolean jude(String name,String password)
    {
        if (name.equals("123")&&password.equals("456"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取输入框传过来的数据
        String user=req.getParameter("username");
        String password=req.getParameter("password");

        // 进行判断,返回相应页面
        if(jude(user,password))
        {
            req.getRequestDispatcher("SuccessfulPage.html").forward(req,resp);
        }
        else
        {
            req.getRequestDispatcher("/ErrorPage.html").forward(req,resp);
        }

    }
}
