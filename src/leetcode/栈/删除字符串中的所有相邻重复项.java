package leetcode.栈;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:53 2021/7/2
 */
public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()&&stack.peek()==s.charAt(i)){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
