import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyJDBC {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(MyJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            System.out.println("1");
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("user"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");

        //注册jdbc驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            System.out.println("22");
            e.printStackTrace();
        }

        //获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            System.out.println("33");
            throwables.printStackTrace();
        }

        System.out.println(connection);

    }
}
