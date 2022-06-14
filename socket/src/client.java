import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        os.write("user=jiang".getBytes());
        os.flush();
        socket.shutdownOutput();

        byte[] data = new byte[1024];
        int len;
        while ((len = is.read(data))!=-1){
            System.out.println(new String(data,0,len));
        }

        socket.close();

    }
}
