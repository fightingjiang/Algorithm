package leetcode.栈.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:07 2021/7/3
 */
public class TestStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
