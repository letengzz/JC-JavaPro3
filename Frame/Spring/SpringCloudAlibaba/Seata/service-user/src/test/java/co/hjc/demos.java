package co.hjc;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demos {
    @Test
    void test() throws ClassNotFoundException, SQLException {
        //1.提供连接的基本信息
        String url = "jdbc:mysql://123.249.12.233:3306/nacos?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "123123";
        String className = "com.mysql.cj.jdbc.Driver";

        //2.获取Driver实现类的对象
        Class.forName(className);
        //相较于方式三，可以省略如下的操作:
        //Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        //DriverManager.registerDriver(driver);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);

        //4.关闭资源
        conn.close();
    }
}
