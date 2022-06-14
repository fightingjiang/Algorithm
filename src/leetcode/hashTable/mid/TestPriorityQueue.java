package leetcode.hashTable.mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 10; i >=0 ; i--) {
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
