import java.util.HashMap;

public class LRUCache01 {

    static class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,DoubleLinkedNode> hashMap = new HashMap<>();
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    int size;
    int capacity;

    public LRUCache01(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key){
        DoubleLinkedNode node = hashMap.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DoubleLinkedNode node = hashMap.get(key);
        if(node==null){
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            hashMap.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DoubleLinkedNode tail = removeTail();
                hashMap.remove(tail.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DoubleLinkedNode removeTail() {
        return null;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DoubleLinkedNode node) {

    }

    private void removeNode(DoubleLinkedNode node) {

    }

}
