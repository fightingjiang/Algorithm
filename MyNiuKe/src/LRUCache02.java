import java.util.HashMap;

public class LRUCache02 {
    public static void main(String[] args) {
        LRUCache02 cache = new LRUCache02(3);
        for (int i = 0; i < 5; i++) {
            cache.put(i,i);
        }
        cache.put(100,100);
        cache.put(3,9);
        cache.show();
    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    int Max_Capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache02(int max_Capacity) {
        Max_Capacity = max_Capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public void show() {
        Node node = head.next;
        for (int i = 0; i < Max_Capacity; i++) {
            System.out.println(node.key+" "+node.value);
            node = node.next;
        }
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        Node node = map.get(key);
        if(node==null){
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            //增加节点到队头
            addToHead(newNode);
            ++size;
            if(size>Max_Capacity){
                //移除队尾节点
                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
