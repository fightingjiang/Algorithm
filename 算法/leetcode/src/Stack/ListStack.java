package Stack;

public class ListStack<T> {
    class Node<T>{
        private T t;
        private Node<T> next;
    }

    private Node<T> head;

    public ListStack() {
        head = null;
    }

    public  void push(T t){
        if(head==null){
            head = new Node<T>();
            head.t = t;
            head.next = null;
        }else{
            Node<T> tmp = null;
            tmp = head;
            head = new Node<T>();
            head.t = t;
            head.next = tmp;
        }

    }

    public T peek(){
        T t = head.t;
        return t;
    }

    public T pop(){
        T t = head.t;
        head = head.next;
        return  t;
    }




}
