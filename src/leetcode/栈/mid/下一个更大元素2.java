package leetcode.栈.mid;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 22:03 2021/7/2
 */
public class 下一个更大元素2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int m = nums.length;
        int[] res = new int[m];
        Arrays.fill(res,-1);
        for (int i = 0; i <2*m-1 ; i++) {
            int j = i%m;
            while (!stack.isEmpty()&&nums[j]>nums[stack.peek()]){
                res[stack.pop()] = nums[j];
            }
            stack.push(j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new 下一个更大元素2().nextGreaterElements(new int[]{1, 2, 1});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
    }
}
