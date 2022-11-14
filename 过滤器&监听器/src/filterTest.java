import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/14 18:02
 */

// 这个就是过滤器，本质上也是一个servlet，只不过在配置后优先执行
public class filterTest implements Filter {
    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }
    // 销毁
    @Override
    public void destroy() {
        System.out.println("销毁");

    }
    // 在这个filter中，将进行文字编码的过滤，从客户端请求，到服务器后进行过滤加工
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("开始设置统一编码字符");

        // 先从用户那边获取用户的编码格式
        String encoding =servletRequest.getParameter("encoding");
        System.out.println("用户的编码格式是: "+encoding);

        servletResponse.setCharacterEncoding(encoding);

        // 继续传递链式
        filterChain.doFilter(servletRequest,servletResponse);
    }


}
