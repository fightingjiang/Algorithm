package iterator;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        Iterator iterator = new InfoCollege().createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
