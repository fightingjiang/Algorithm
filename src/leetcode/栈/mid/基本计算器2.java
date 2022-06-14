package leetcode.栈.mid;

import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:03 2021/7/2
 */
public class 基本计算器2 {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }
            if (!Character.isDigit(c) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    default:
                        stack.push(stack.pop()/num);
                }
                preSign = c;
                num = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
