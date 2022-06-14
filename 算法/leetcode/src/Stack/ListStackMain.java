package Stack;

public class ListStackMain {
    public static void main(String[] args) {
        ListStack<String> listStack = new ListStack<>();
        listStack.push("jiang");
        listStack.push("zhi");
        listStack.push("hao");
        System.out.println(listStack.peek());
        System.out.println(listStack.pop());


    }
}
