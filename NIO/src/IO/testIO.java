package IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Properties;

public class testIO {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        File absoluteFile = file.getAbsoluteFile();
        FileInputStream fis = new FileInputStream("test.txt");
        FileOutputStream fos = new FileOutputStream("test_copy.txt");
        byte[] buffer = new byte[1024];
        fis.read(buffer);
        fos.write(buffer,0,buffer.length);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }
}
