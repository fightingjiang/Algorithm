package Soket;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client01 {
    public static void send() throws IOException {
        Socket socket = new Socket("localhost", 8888);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        os.write("lalala".getBytes());
        os.flush();
        socket.shutdownOutput();

        byte[] data = new  byte[1024];
        int len;
        while ((len=is.read(data))!=-1){
            System.out.println(new String(data,0,len));
        }
        socket.close();
    }

}
