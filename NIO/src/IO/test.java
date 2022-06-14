package IO;

import java.io.*;

public class test {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("1.PNG");
        FileOutputStream fos = new FileOutputStream("4.PNG");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buf = new byte[1024];
        while (bis.read(buf)!=-1){
            bos.write(buf,0,buf.length);
            bos.flush();
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("5.txt"));
        String str = null;
        while (( str = bufferedReader.readLine())!=null){
            bufferedWriter.write(str,0,str.length());
            System.out.println(str);
            bufferedWriter.flush();
        }
    }
}
