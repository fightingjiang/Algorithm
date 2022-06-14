package Stack;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.push("jiang");
        strings.push("zhi");
        strings.push("hao");
        System.out.println(strings.get(0));
        System.out.println(strings.peek());
    }
}
