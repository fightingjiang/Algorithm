package collections;

import java.util.HashMap;

public class MyLruCache {
    class DoubleLinkedNode{
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

    private HashMap<Integer,DoubleLinkedNode> hashMap = new HashMap<>();
    int capacity;
    int size ;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;

    public MyLruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
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
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    //插到双向链表前面
    private void moveToHead(DoubleLinkedNode node) {
       removeNode(node);
       addToHead(node);
    }

    private void removeNode(DoubleLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addToHead(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}
