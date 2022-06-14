package NonBlockingNIO;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), 9090));
        socketChannel.configureBlocking(false);

        //分配缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((Thread.currentThread().getName()+"   "+str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //关闭通道
        socketChannel.close();

    }
}
