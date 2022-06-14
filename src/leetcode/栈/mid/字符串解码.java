package leetcode.栈.mid;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:13 2021/7/3
 */
public class 字符串解码 {
    String s ;
    public String decodeString(String s) {
        index = 0;
        this.s = s;
        return getString();
    }

    private String getString() {
        if(index>=s.length()||s.charAt(index)==']'){
            return "";
        }
        char cur = s.charAt(index);
        String res = "";
        int repTime = 1;
        if(Character.isDigit(cur)){
            repTime = getDigit();
            index++;
            String str = getString();
            index++;
            while (repTime-->0){
                res+=str;
            }
        }else if(Character.isLetter(cur)){
            res=String.valueOf(s.charAt(index++));
        }
        return res+getString();
    }

    private int getDigit() {
        int res = 0;
        while (index<s.length()&&Character.isDigit(s.charAt(index))){
            res = res*10+s.charAt(index++)-'0';
        }
        return res;
    }

    int index ;

    public String decodeStringUseStack(String s) {
        Deque<String> stack = new LinkedList<>();
        index = 0;
       while (index<s.length()){
            char ch = s.charAt(index);
            if(ch==']'){
                index++;
                String str = "";
                while (!stack.peek().equals("[")){
                    str = stack.pop()+str;
                }
                System.out.println(str);
                String tmp = "";
                stack.pop();
                int repTime = Integer.parseInt(stack.pop());
                while (repTime-->0){
                    tmp+=str;
                }
                stack.push(tmp);
            }else if(Character.isDigit(ch)){
                stack.push(getDigit(s));
            }else {
                stack.push(s.charAt(index++)+"");
            }
        }
        StringBuilder sb = new StringBuilder();
       while (!stack.isEmpty()){
           sb.append(stack.pollLast());
       }
       return sb.toString();
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(index))){
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new 字符串解码().decodeStringUseStack("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
