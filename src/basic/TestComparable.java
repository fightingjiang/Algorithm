package basic;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:12 2021/7/25
 */
public class TestComparable {
    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
    }
}
