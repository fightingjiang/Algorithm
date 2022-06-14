package File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
    public static void  read(String src) throws Exception {
        FileReader fileReader = new FileReader(src);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws Exception {
        String src = "D:\\桌面\\algorithm\\IO\\src\\File\\test";
        read(src);
    }
}
