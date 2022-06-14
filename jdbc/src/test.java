import com.mysql.jdbc.Driver;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class test {
    public static void main(String[] args) throws Exception {
//        InputStream is = test.class.getClassLoader().getResourceAsStream("test.txt");
//        Properties pro = new Properties();
//        pro.load(is);
//
//        String user = (String) pro.get("name");
//        String password = (String) pro.get("password");
//        String url = pro.getProperty("url");
//        String driverclass = pro.getProperty("driverclass");
//
//        //加载驱动
//        Class.forName(driverclass);
//
//        //获取链接
//        Connection connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from student ");
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int columnCount = metaData.getColumnCount();


        InputStream is = test.class.getClassLoader().getResourceAsStream("test.txt");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverclass = properties.getProperty("driverclass");

        Class.forName(driverclass);

        Connection connection = DriverManager.getConnection(user, password, url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String columnLabel = metaData.getColumnLabel(1);




    }
}
