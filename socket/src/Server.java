
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        byte[] data = new byte[1024];
        int len;
        while ((len = is.read(data))!=-1) {
            System.out.println(new String(data, 0, len));
        }


        os.write("welcome".getBytes());
        os.flush();

        socket.close();
        serverSocket.close();

    }
}
