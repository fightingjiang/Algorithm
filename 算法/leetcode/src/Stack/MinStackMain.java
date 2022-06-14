package Stack;

public class MinStackMain {
    public static void main(String[] args) {
        ArrayStack<String> minStack = new ArrayStack<>();
        minStack.push("jiang");
        minStack.push("zhi");
        minStack.push("hao");
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
        System.out.println(minStack.pop());

    }
}
