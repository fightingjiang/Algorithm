package Soket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("49.123.94.213", 8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        os.write("lalala".getBytes());
        os.flush();
        socket.shutdownOutput();

        byte[] data = new  byte[1024];
        int len;
        while ((len=is.read(data))!=-1){
            System.out.println(new java.lang.String(data,0,len));
        }
        socket.close();
    }
}
