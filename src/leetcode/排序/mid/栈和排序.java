package leetcode.排序.mid;

import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:25 2021/7/10
 */
public class 栈和排序 {
    public int[] solve (int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            vis[a[i]] = true;
            //只有当大的放入栈了  n才会减小
            while (n>0&&vis[n]) n--;
            while (!stack.isEmpty()&&stack.peek()>=n){
                ans[index++] = stack.pop();
            }
        }
        while (!stack.isEmpty()){
            ans[index++] = stack.pop();
        }
        return ans;
    }
}
