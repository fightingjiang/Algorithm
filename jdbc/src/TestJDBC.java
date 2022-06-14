import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestJDBC {
    public static void main(String[] args) {
        //配置信息
        Properties properties = new Properties();
        try {
            properties.load(TestJDBC.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            System.out.println("11");
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");

        //注册jdbc驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            System.out.println("22");
            throwables.printStackTrace();
        }

        System.out.println(connection);

    }
}
