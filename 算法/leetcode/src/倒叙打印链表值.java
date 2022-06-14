public class 倒叙打印链表值 {


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node.next = node1;
        node1.next = node2;
        print(node);
    }

    public static void print(Node root){
        if(root==null) return;
        print(root.next);
        System.out.println(root.val);
    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}