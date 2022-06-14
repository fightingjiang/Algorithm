package collections;


public class LinkedList手写<E> {
    class Node<E>{
        E value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }
    }

    Node<E> head;
    Node<E> tail;
    private int size = 0;

    public LinkedList手写() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    public void addFirst(E e){
        size++;
        addToHead(new Node<>(e));
    }

    private void addToHead(Node<E> node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void add(E e){
        addLast(e);
    }

    public void addLast(E e){
        size++;
        addToLast(new Node<>(e));
    }

    private void addToLast(Node<E> node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    public E poll(){
        size--;
        Node node = head.next;
        removeNode(node);
        return (E) node.value;
    }

    public E removeLast(){
        size--;
        Node node = tail.pre;
        removeNode(node);
        return (E) node.value;
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void show(){
        Node node = head.next;
        System.out.print("[");
        for (int i = 0; i < size-1; i++) {
            System.out.print(node.value+",");
            node = node.next;
        }
        System.out.print(node.value+"]"+"\n");
    }

    public static void main(String[] args) {
        LinkedList手写<Integer> list = new LinkedList手写<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.show();
        System.out.println(list.poll());
        System.out.println(list.removeLast());
        list.show();
    }
}
