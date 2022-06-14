package MyQueue;

public class MyLinkedQueue {
    static class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    private Node head;
    private Node tail;
    private int size;

    public MyLinkedQueue() {
    }

    public void offer(int value){
        Node node = new Node(value, null);
        if(tail==null){
            head = tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int peek(){
        return head==null?-1:head.value;
    }

    public int poll(){
        if(head==null) return -1;
        Node h = head;
        head = head.next;
        h.next = null;
        if(head==null){
            tail = null;
        }
        size--;
        return h.value;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if(size==0) return "{}";
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Node h = head;
        while (h!=null){
            builder.append(h.value).append(",");
            h = h.next;
        }
        return builder.substring(0,builder.length()-1)+"}";
    }

    public static void main(String[] args) {
        MyLinkedQueue queue = new MyLinkedQueue();
        for (int i = 3; i < 10; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 2; i++) {
            queue.poll();
        }
        System.out.println(queue.toString());
        System.out.println(queue.size());
    }
}
