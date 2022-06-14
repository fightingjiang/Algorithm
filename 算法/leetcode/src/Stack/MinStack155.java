package Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Stack;

public class MinStack155 {
    class   Node{
        Integer data;
        Integer min;

        public Node(Integer data, Integer min) {
            this.data = data;
            this.min = min;
        }
    }

    private Stack<Node> stack;

    /** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new Node(x,x));
        }else{
           stack.push(new Node(x,Math.min(x,stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().data;
    }

    public int getMin() {
        return stack.peek().min;
    }


}
