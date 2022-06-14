package leetcode.栈.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:51 2021/7/3
 */
public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int m = heights.length;
        int[] left = new int[m];
        int[] right = new int[m];
        Deque<Integer> stack = new LinkedList<>();
        //向右找一个比自己小的  如果没有找到就是说右边都比  那为m
        for (int i = 0; i < m; i++) {
            right[i] = m;
            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                Integer pop = stack.pop();
                right[pop] = i;
            }
            stack.push(i);
        }
        stack.clear();
        //向左找一个比自己小的 如果没有找到就是-1
        for (int i = m-1; i >=0; i--) {
            left[i] = -1;
            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                Integer pop = stack.pop();
                left[pop] = i;
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 柱状图中最大的矩形().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
