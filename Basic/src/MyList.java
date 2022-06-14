public class MyList {
    Node head ;

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        head.setNext(node1);
        node1.setNext(node2);
        head = Reverse(head);
        while (head!=null){
            System.out.println(head.getValue());
            head = head.getNext();
        }

    }

    private static Node Reverse(Node head) {
        if (head == null||head.getNext()==null) {
            return head;
        }
        Node pre = head;
        Node curr = head.getNext();
        Node tmp ;
        while (curr!=null){
            tmp = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = tmp;
        }
        head.setNext(null);
        return  pre;
    }

}

class Node{
    private int value ;
    private Node next ;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
