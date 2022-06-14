package leetcode.栈.mid;

import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:39 2021/7/2
 */
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        int m = temperatures.length;
        int[] nums = new int[m];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                nums[pop] = i-pop;
            }
            stack.push(i);
        }
        return nums;
    }
}
