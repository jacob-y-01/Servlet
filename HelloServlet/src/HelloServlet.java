import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

//class helloservlet extends HttpServlet{
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//    }
//}

public class HelloServlet implements Servlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  NullPointerException,ServletException, IOException {

        System.out.println("doPost方法");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2接收数据
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println(username+" "+pwd);
        //直接判断
        if(username.equals("admin")&&pwd.equals("123")){
            Cookie[] cookies=request.getCookies();
            System.out.println("cookie"+cookies.toString());

            /* 创建cookie */
            Cookie name = new Cookie("admin",request.getParameter("username"));



            // 设置过期时间
            name.setMaxAge(60*60*1);

            // 加入到相应头中
            response.addCookie( name );

            // 设置文字，重定向
            response.setContentType("text/html;charset=UTF-8");
            response.sendRedirect("index.html");
        }else{
            //重定向
            response.sendRedirect("register.html");
        }
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws NullPointerException,IOException,ServletException{
        System.out.println("service方法");
        //doPost((HttpServletRequest)servletRequest,(HttpServletResponse)servletResponse);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法");
        doPost(request, response);
    }
    @Override
    public void init(ServletConfig servletConfig) {
        System.out.println("初始化......");
    }

    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
//        // http://localhost:8080/HelloServlet?username=124&password=123
//        System.out.println("servlet服务......");
//        String username = servletRequest.getParameter("username");
//        String password = servletRequest.getParameter("password");
//        System.out.println(username+"    "+password);
//    }


    public void destroy() {
        System.out.println("销毁......");
    }
    // 获取servlet配置信息
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("获取servlet配置信息");
        return null;
    }

    // 获取servlet基本信息
    @Override
    public String getServletInfo() {
        System.out.println("获取servlet基本信息");
        return null;
    }
}
