import sun.nio.ch.FileChannelImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class TestChannel {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("1.PNG");
        FileOutputStream fos = new FileOutputStream("2.PNG");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        //把inchannel中的数据写道buf
        while (inChannel.read(buf)!=-1){
            //切换buf模式
            buf.flip();
            //将数据写道buf
            outChannel.write(buf);
            buf.clear();
        }

    }
}
