import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //加载驱动
        Class.forName("da");
        String url = " ";
        //建立链接
        Connection connection = DriverManager.getConnection(url);
        String sql = "";
        //生成 statement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执行sql语句

        preparedStatement.execute();
    }
}
