package leetcode.栈.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:41 2021/7/4
 */
public class 接雨水 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0,m = height.length;
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                Integer top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                ans+=(Math.min(height[left],height[i])-height[top])*(i-left-1);
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap1(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0,m = height.length;
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                Integer pop = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                ans+=(Math.min(height[i],height[left])-height[pop])*(i-left-1);
            }
            stack.push(i);
        }
        return ans;
    }

    //双指针
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0,right = height.length-1;
        int leftMax = Integer.MIN_VALUE,rightMax = Integer.MIN_VALUE;
        while (left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax<rightMax){
                ans+=leftMax-height[left];
                left++;
            }else {
                ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
