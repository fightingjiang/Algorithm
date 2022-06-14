package File;

import java.io.*;

public class CopyFile {
    public static void copyfile(String src,String dist) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dist);
        byte[] data = new byte[1024*20];
        int len;
        while ((len=fis.read(data))!=-1){
            fos.write(data,0,len);
        }

        fis.close();
        fos.close();
    }

    public static void copyfile01(String src,String dist) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream(dist);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);
        byte[] data = new byte[1024*20];
        int len;
        while ((len=bufferedInputStream.read(data))!=-1){
            bufferedOutputStream.write(data,0,len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();
    }



    public static void main(String[] args) throws Exception {
        String dir = "D:\\桌面\\algorithm\\IO\\src\\File\\test";
        String dist = "D:\\桌面\\algorithm\\IO\\src\\File\\test_copy";
        copyfile(dir,dist);
    }
}
