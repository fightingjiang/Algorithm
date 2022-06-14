package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("jiang");
        int [] a = {1,2,3};
        for (int i : a) {

        }
        LinkedList<Object> objects = new LinkedList<>();
        Iterator<Object> iterator1 = objects.iterator();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
