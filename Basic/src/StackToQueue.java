import java.util.Stack;

public class StackToQueue<T> {
        Stack<T> inStack ;
        Stack<T> outStack ;

    public StackToQueue() {
        inStack = new Stack<T>();
        outStack = new Stack<T>();
    }

    public void enqueue(T t){
        inStack.push(t);
    }

    public T dequeue(){
        T tmp = null;
        if(!outStack.isEmpty()){
            tmp = outStack.pop();
        }else {
            while (!inStack.isEmpty()){
                tmp = inStack.pop();
                outStack.push(tmp);
            }
            if(!outStack.isEmpty()){
                tmp = outStack.pop();
            }
        }
        return tmp;
    }

    public void clear(){
        inStack.clear();
        outStack.clear();
    }

    public boolean isEmpty(){
        return inStack.isEmpty()&&outStack.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue<String> queue = new StackToQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
