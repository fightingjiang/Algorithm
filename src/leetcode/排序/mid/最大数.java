package leetcode.排序.mid;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 18:08 2021/7/9
 */
public class 最大数 {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> (o2+o1).compareTo(o1+o2));
        for (int x:nums) heap.offer(String.valueOf(x));
        String res = "";
        while (!heap.isEmpty()) res+=heap.poll();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
