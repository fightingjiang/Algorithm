import java.util.EmptyStackException;

public class MyStack {
    private  int maxSize;
    int[] stack;
    private int top;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
        top = -1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    private boolean isFull(){
        return top ==maxSize-1;
    }

    public void push(int num){
        if(isFull()){
            throw new StackOverflowError("栈满");
        }
        top++;
        stack[top] = num;
    }

    public int poll(){
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
    }
}
