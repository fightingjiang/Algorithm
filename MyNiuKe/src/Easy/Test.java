package Easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        char ch = 'a';
        switch (ch){
            case 'a':
                System.out.println("aa");
                break;
            case 'b':
                System.out.println("bbb");
        }

        queue.add(1);
        queue.add(10);
        queue.add(3);
        queue.add(2);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
