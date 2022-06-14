package Soket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("49.123.94.213",8888);
        server.bind(inetSocketAddress);
        //监听一个客户端
        Socket socket = server.accept();

        //获取输入流
        InputStream is = socket.getInputStream();

//        获取输出流
        OutputStream os = socket.getOutputStream();
//        通信，接受数据
        byte[] data = new byte[1024];
        int len;
        while ((len=is.read(data))!=-1){
            System.out.println(new String(data,0,len));
        }


//        发送数据
        os.write("欢迎登录".getBytes());
        os.flush();



        //关闭socket
        socket.close();
        //关闭server
        server.close();

    }
}
