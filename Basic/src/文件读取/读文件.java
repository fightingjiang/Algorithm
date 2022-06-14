package 文件读取;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class 读文件 {
    public static void main(String[] args) throws IOException {
        InputStream resource = 读文件.class.getClassLoader().getResourceAsStream("application.properties");
        Properties properties = new Properties();
        System.out.println(resource);
        properties.load(resource);
        properties.getProperty("scanPackage");
    }
}
