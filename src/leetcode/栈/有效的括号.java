package leetcode.栈;

import java.util.*;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:00 2021/6/27
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        if(s==null||s.length()==0) return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(!stack.isEmpty()||map.get(c)!=stack.pop()){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
