package File;

import java.io.File;

public class fileTest {
    public static void main(String[] args) {
        File dir = new File("D:\\桌面\\algorithm\\IO\\src");
        listAllfiles(dir);
    }

    public static void listAllfiles(File dir){
        if(dir==null||!dir.exists()){
            return;
        }
        if(dir.isFile()){
            System.out.println(dir.getName());
        }
        for (File file:dir.listFiles()){
            listAllfiles(file);
        }
    }
}
