package leetcode.双指针;

import java.beans.beancontext.BeanContext;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:55 2021/7/15
 */
public class 接雨水 {
    public long maxWater_doublePoint (int[] arr) {
        long res = 0l;
        if(arr==null||arr.length==0) return res;
        int l = 0,r = arr.length-1;
        int leftMax = 0,rightMax = 0;
        while (l<r){
            leftMax = Math.max(arr[l],leftMax);
            rightMax = Math.max(arr[r],rightMax);
            if(arr[l]<arr[r]){
                res+=leftMax-arr[l];
                l++;
            }else {
                res+=rightMax-arr[r];
                r--;
            }
        }
        return res;
    }


    //单调栈解决   维护一个不减的栈
    public long maxWater_stack (int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        long res = 0l;
        long n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                long currWidth = i-left-1;
                res+=currWidth*(Math.min(arr[left],arr[i])-arr[top]);
            }
            stack.push(i);
        }
        return res;
    }
}
