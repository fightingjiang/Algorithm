package 牛客100题;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存 {

    public static void main(String[] args) {
        LRU缓存 lru = new LRU缓存(5);
        for (int i = 0; i < 6; i++) {
            lru.put(i,i+10);
        }
        lru.get(4);
        for (int i = 10; i < 11; i++) {
            lru.put(i,i+10);
        }
        lru.show();
    }

    private void show() {
        Node node = head.next;
        while(node!=null&&node.next!=null){
            System.out.println(node.key+" "+node.value);
            node = node.next;
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node() {
        }
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> map = new HashMap();

    public LRU缓存(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        //移动到链表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        Node node = map.get(key);
        if(node==null){
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                //删除链表尾节点
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void addToHead(Node node) {
        //头插法
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

}
