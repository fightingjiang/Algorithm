package MyList;

import java.util.LinkedList;

public class MyLinkedList {
    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head = new Node(0);
    private Node tmp = head;

    public void add(int num){
        Node node = new Node(num);
        tmp.next = node;
        tmp = tmp.next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        Node next = head.next;
        while (next!=null){
            builder.append(next.value).append(",");
            next = next.next;
        }
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
    }
}
