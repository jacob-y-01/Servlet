import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;


// 过滤器可以有多个
// 但是要注意他们是并列关系而，非串行关系
// 并没有先后，ABCD...非流水线式
// 而是，扎堆A做xx，B做XX
// filter就像一个工厂，消息先进入，被处理，内部处理顺序不定
public class filterTest2 implements Filter {



    /**
     * getRequestURL:(将HttpServletRequest转成URL参数字符串 ). <br/>
     */
    public static String getRequestURL(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        @SuppressWarnings("unchecked")
        Enumeration<String> er = request.getParameterNames();
        while (er.hasMoreElements()) {
            String name = (String) er.nextElement();
            String value = request.getParameter(name);
            if (isFirst) {
                sb.append(name + "=" + value);
                isFirst = false;
            }
            else {
                if (value != null) {
                    sb.append("&" + name + "=" + value);
                }
                else {
                    sb.append("&" + name + "=");
                }
            }
        }
        return sb.toString();
    }



    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器2初始化");
    }
    // 销毁
    @Override
    public void destroy() {
        System.out.println("过滤器2销毁");

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 本过滤器负责打印客户的访问日志
        HttpServletRequest Hsreq=(HttpServletRequest)servletRequest;
        System.out.println(Hsreq.getRequestURL()+"正在使用"+Hsreq.getMethod()+"尝试访问");

        System.out.println(getRequestURL(Hsreq));


        // 继续链路
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
