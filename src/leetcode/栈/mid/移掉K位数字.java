package leetcode.栈.mid;

import java.awt.font.NumericShaper;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:26 2021/7/2
 */
public class 移掉K位数字 {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty()&&ch<stack.peek()&&k>0){
                stack.pop();
                k--;
            }
            if(stack.isEmpty()&&ch=='0') continue;
            stack.push(ch);
        }
        while (k-->0&&!stack.isEmpty()){
            stack.pop();
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.length()==0?"0":sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new 移掉K位数字().removeKdigits("100001", 4));
    }
}
