package IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class bufferStream {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a"));

    }
}
