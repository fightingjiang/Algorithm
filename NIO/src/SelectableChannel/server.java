package SelectableChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get("6.PNG"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        serverSocketChannel.bind(new InetSocketAddress(9090));
        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (socketChannel.read(buffer)!=-1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();
    }
}
