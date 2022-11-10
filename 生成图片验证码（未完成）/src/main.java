import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/3 16:38
 */
public class main extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("gb2312");
        resp.getWriter().print("这里是生成验证码测试");

        // 设置响应类型
        resp.setContentType("image/jpeg");

        // 设置页面不缓存
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);

        // 创建图像
        BufferedImage pic=new BufferedImage(60,20,BufferedImage.TYPE_INT_RGB);

        // 获取图像上下文环境
        Graphics gc=pic.createGraphics();

        // 设置背景色，并且进行
        //
        // 填充
        gc.setColor(new Color(65535));
        gc.fillRect(0,0,60,20);

        // 设定图像上下文环境字体
        gc.setFont(new Font("Times New Roam",Font.PLAIN,20));

        // 随机在图像上画干扰直线
        Random r=new Random();
        for (int i=0;i<200;i++)
        {
            int x1=r.nextInt(60);
            int y1=r.nextInt(20);
            int x2=r.nextInt(15);
            int y2=r.nextInt(15);
            gc.setColor(new Color(0));
            gc.drawLine(x1,y1,x1+x2,y1+y2);
        }

        // 随机出现10个干扰点
        for (int i=0;i<10;i++)
        {
            int x=r.nextInt(60);
            int y=r.nextInt(20);
            gc.setColor(new Color(100));
            gc.drawOval(x,y,0,0);
        }
        // 随机生成验证码数字
        String rs=r.nextInt(9000)+1000+"";

        // 数字写入到图像里
        gc.setColor(new Color(20+r.nextInt(110),20+r.nextInt(110),20+r.nextInt(110)));
        gc.drawString(rs,10,16);

        // 释放所使用过的环境
        gc.dispose();

        // 显示到网页
        ImageIO.write(pic,"JPEG",resp.getOutputStream());
    }
}