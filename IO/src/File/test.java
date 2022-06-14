package File;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        String path="D:\\桌面\\algorithm\\IO\\src\\File\\test";
        String pathOut="D:\\桌面\\algorithm\\IO\\src\\File\\LinkedHashMap_copy.java";
        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        System.out.println(line);
    }
}
