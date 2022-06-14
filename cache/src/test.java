import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        ClassLoader classLoader = test.class.getClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(HashMap.class.getClassLoader());
    }
}
