import javax.servlet.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/2 16:19
 */

// 使用实现接口方法就必须按要求重写接口
public class servletTest2 implements Servlet {
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse servletResponse) throws IOException {
        // 客户——>浏览器——>tomcat——>调用容器——>根据所访问的名字，找到映射相应的servlet——>servlet执行本方法


        //***********************************
        //
        //     ServletRequest接口
        //
        //***********************************
        // 以下代码同样在 extern HttpServlet的servlet中也可以使用
        System.out.println("servlet1 service function");
        System.out.println("获取客户端请求的总长度"+req.getContentLength());
        System.out.println("获取客户端请求正文的类型"+req.getContentType());
        // System.out.println("返回用于读取请求正文的输入流？？？"+req.getInputStream());
        //System.out.println("返回用于读取字符串形式的请求正文的bufferreader对象"+req.getReader());

        System.out.println("返回服务端的IP地址"+req.getLocalAddr());
        System.out.println("返回服务器的主机名"+req.getLocalName());
        System.out.println("返回服务器的端口号"+ req.getLocalPort());

        System.out.println("返回客户端IP地址"+req.getRemoteAddr());
        System.out.println("返回客户端主机名"+req.getRemoteHost());
        System.out.println("返回客户端端口号"+req.getRemotePort());

        System.out.println("返回通信协议名称，及版本号"+req.getProtocol());
        // System.out.println("根据给定的请求参数名，返回来自客户请求中匹配的请求参数值"+req.getParameter());


        //***********************************
        //
        //      ServletResponse接口
        //
        //***********************************

        // 设置响应字符编码
        servletResponse.setCharacterEncoding("utf-8");

        // 设置相应正文长度
        servletResponse.setContentLength(1000);

        // 设置相应正文的MIME类型
        servletResponse.setContentType(req.getContentType());
        System.out.println(req.getContentType());

        // 获取响应正文的字符编码
        System.out.println(servletResponse.getCharacterEncoding());

        // 设置响应正文缓冲区的大小，让返回的数据限定在一定大小，防止有人恶意让其只为其一个响应大量数据，或者缓冲区溢出
        servletResponse.setBufferSize(1000);

        // 也可以获取其大小
        System.out.println(servletResponse.getBufferSize());

        // 清空响应“所有”缓冲区数据
        servletResponse.reset();

        // 仅清空数据区，而不清空头部数据，注意遇上一个不同
        servletResponse.resetBuffer();

        // 强制响应，缓冲区的数据强行推送给客户端
        //servletResponse.flushBuffer();

        // 查看是否已经将缓冲区数据推送给客户
        System.out.println("是否已经推送缓冲区数据到客户端？"+servletResponse.isCommitted());

        // 响应二进制数据和响应文本消息

        InputStream in=null;
               in =new FileInputStream("D:\\Desktop\\servlet\\servletAPI详解ServletRequest和HttpServletRequest\\web\\ju.gif");
        System.out.println("文件是否为空"+in==null);

        // 获取到二进制响应流
        ServletOutputStream outputStream=servletResponse.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0 ;
        //循环读取字节，并输入到页面
        while ((len = in.read(bytes)) !=-1){
            outputStream.write(bytes , 0,len);
        }
        in.close();
        outputStream.close();




        // 响应文字

        String result = "您好，欢迎访问 servlet2！";
        //返回结果
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        // 获取PrintWriter对象
        PrintWriter out = servletResponse.getWriter();
        out.print(result);
        // 释放PrintWriter对象
        out.flush();
        out.close();
    }
    @Override
    public void init(ServletConfig servletConfig) {

    }

    @Override
    public void destroy() {

    }
}