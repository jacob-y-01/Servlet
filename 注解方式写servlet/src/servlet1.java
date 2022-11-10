import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/1 17:01
 */
    // 将一个类声明为servlet，部署后被容器处理，根据注解指定的类，找到servlet
/*
括号内各种属性（WebServlet）
    String name() default "";
    等价===XML中<servlet-name>

    String[] value() default {};
    等价===urlPatterns（下一个属性）

    String[] urlPatterns() default {};
    等价===<urlPatterns>

    int loadOnStartup() default -1;
    等价===<load-on-startup>指定servlet加载顺序


    WebInitParam[] initParams() default {};
    等价===<init-param>指定一组servlet初始化参数

    boolean asyncSupported() default false;
    //异步操作

    String smallIcon() default "";
    String largeIcon() default "";
    String description() default "";
    servlet描述信息

    String displayName() default "";
    servlet的显示名
*/
//urlPatterns = {""}默认8080访问的就是本servlet
//urlPatterns = {"/*"}后面任意字符都是本servlet
@WebServlet(urlPatterns = {"/*"},asyncSupported = true,loadOnStartup = -1,name = "name",displayName = "display name",initParams = {@WebInitParam(name="username",value="Name value")})
public class servlet1 extends HttpServlet
{
    public servlet1()
    {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("get请求");

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>get请求</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post请求");

        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>post请求</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
