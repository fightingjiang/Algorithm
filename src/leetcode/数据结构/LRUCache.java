package leetcode.数据结构;

import java.util.HashMap;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:46 2021/7/14
 */
public class LRUCache {
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

    HashMap<Integer,DoubleLinkedNode> map = new HashMap<>();
    int capacity;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DoubleLinkedNode node = map.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DoubleLinkedNode node = map.get(key);
        if(node==null){
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            map.put(key,newNode);
            addToHead(newNode);
            if(map.size()>capacity){
                DoubleLinkedNode tail = removeTail();
                map.remove(tail.key);
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DoubleLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    //头插法
    private void addToHead(DoubleLinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }
}
