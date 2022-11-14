import sun.text.resources.iw.FormatData_iw_IL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/13 14:23
 */
public class FileTransformationTest extends HttpServlet {


    // 负责返回文件
    public  byte[]  ReadFile(String FilePath) throws IOException {

        // 读取二进制文件并且返回
        FileInputStream file = new FileInputStream(FilePath);
        InputStream inStream = file;

        // 将其转换成byte数组
        byte[] byt = new byte[inStream.available()];
        inStream.read(byt);

        inStream.close();
        file.close();

        return byt;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法");
        resp.getWriter().print("successful to download file（Get）");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("用户已经提交");


        // 获取客户端的选项
        String [] role =req.getParameterValues("radio");




        //判断选项，根据选择，返回文件
        switch (role[0])
        {
            case "word":
                resp.setContentType("application/msword;charset=UTF-8");
                resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("word文档下载测试.docx", "UTF-8"));
                resp.getOutputStream().write(ReadFile("D:\\Desktop\\servlet\\网页文件传输\\CZ0419030161余子贤任务规划.docx"));
                break;
            case "exe":
                resp.setContentType("text/x-msdownload;charset=UTF-8");
                resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("exe下载测试.exe", "UTF-8"));
                resp.getOutputStream().write(ReadFile("D:\\Desktop\\servlet\\网页文件传输\\baidunetdisk.exe"));
                break;
            case "png":
                resp.setContentType("application/x-png;charset=UTF-8");
                resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("图片下载测试.png", "UTF-8"));
                resp.getOutputStream().write(ReadFile("D:\\Desktop\\servlet\\网页文件传输\\课表.PNG"));
                break;
            case "video":
                resp.setHeader("content-type", "text/html;charset=UTF-8");
                resp.getWriter().print("无法响应视频（我暂时没搞）！");
                break;
            case "tar":
                resp.setContentType("text/x-msdownload;charset=UTF-8");
                resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("压缩包下载测试.zip", "UTF-8"));
                resp.getOutputStream().write(ReadFile("D:\\Desktop\\servlet\\网页文件传输\\课表.zip"));
                break;
        }
        //resp.getWriter().print("successful to download file（Get）");
    }
}
