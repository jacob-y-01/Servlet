package Myconnection;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import java.io.*;

/**
 * @author Jacob-Y
 * @version 1.0
 * @date 2022/11/10 14:51
 */
public class ThreadPool_JDBCtest implements DataSource {

    // 在这里存储与客户端的链接，客户链接的删减可能很频繁，所以链式结构较优
    private List<Connection> conns =new LinkedList<Connection>();

    // 构造函数
    public ThreadPool_JDBCtest(String SettingFileName)throws IOException,ClassNotFoundException,SQLException
    {

        System.out.println("ThreadPool_JDBCtest构造函数");
        // 链接最大数
        int ConnectCount=10;

        // 根据配置名称获得inputstream对象

        // 获取配置，从同目录下的jdbc.properties获取配置
        Properties prop=new Properties();
        prop.load(new FileInputStream(SettingFileName));
        String url=prop.getProperty("url");
        String user=prop.getProperty("user");
        String password=prop.getProperty("password");
        String driver =prop.getProperty("driver");


        System.out.println(url+user+password+driver);
        // 加载数据库驱动
        Class.forName(driver);

        // 创建10个链接丢到conns里
        for (int i=0;i<ConnectCount;i++)
        {
            Connection conn=DriverManager.getConnection(url,user,password);
            conns.add(conn);
        }
    }


    // 重写方法

    //*******************************************
    //   客户端发起请求，就从conns中拿出一个来
    ///  将其包装成MyConnection,与客户端进行通信
    //*******************************************
    @Override
    public MyConnection getConnection() {
        // 移出来一个链接
        Connection conn=conns.remove(0);
        System.out.println("线程池还剩下"+conns.size()+"个链接");
        return new MyConnection(conn,conns);
    }

    @Override
    public PrintWriter getLogWriter() {
        return null;
    }

    @Override
    public int getLoginTimeout() {
        return 0;
    }

    @Override
    public Logger getParentLogger() {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) {
        return null;
    }

    @Override
    public void setLoginTimeout(int seconds) {

    }

    @Override
    public void setLogWriter(PrintWriter out) {

    }

    @Override
    public boolean isWrapperFor(Class<?> iface) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) {
        return null;
    }
}
