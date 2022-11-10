import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Myconnection.*;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/10 16:11
 */
public class servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        System.out.println("service 请求，接下来service，请求数据库");
        // 在这里做查询和链接请求；

        // 新建一个链接对象，读取配置文件
        ThreadPool_JDBCtest TPJ = null;
        try {
            TPJ=new ThreadPool_JDBCtest("D:\\Desktop\\servlet\\连接池与JDBC技术\\src\\jdbc.properties");
        } catch (ClassNotFoundException e) {
            System.out.println("捕捉到异常 ClassNotFoundException");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("捕捉到异常 SQLException");
            e.printStackTrace();
        }

        System.out.println("链接的创建，使用TPJ创建链接池");
        MyConnection mc= TPJ.getConnection();


        //*******************************
        //        进行查询操作
        //*******************************


        try {
            PreparedStatement ps=mc.conn.prepareStatement("select * from student");
            ResultSet rs= ps.executeQuery();

            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out=resp.getWriter();


            out.print("学号   姓名    性别   年龄   班级");
            out.print("<br>");
            // 显示到网页中
            while (rs.next())
            {
                out.print(rs.getString(1)+"  "+
                        rs.getString(2)+"  "+
                        rs.getString(3)+"  "+
                        rs.getInt(4)+"  "+
                        rs.getString(5));
                out.print("<br>");
            }
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }






        System.out.println("关闭mc的链接");
        mc.close();

        //super.service(req, resp);
    }
}
