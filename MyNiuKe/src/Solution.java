import java.util.ArrayList;
import java.util.HashMap;


public class Solution{
    public int[] LRU (int[][] operators, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        LRUCache lruCache = new LRUCache(k);
        for (int i = 0; i < operators.length; i++) {
            int[] op = operators[i];
            if(op[0]==1){
                lruCache.put(op[1],op[2]);
            }else {
                list.add(lruCache.get(op[1]));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class LRUCache {

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
    int size;
    DoubleLinkedNode head;
    DoubleLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DoubleLinkedNode node = map.get(key);
        if(node==null) return -1;
        //移动到链表头
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        //现根据key取出node
        DoubleLinkedNode node = map.get(key);
        //若node为空 则原来map中没有
        if(node==null){
            //new节点  然后加入map，添加到双向链表头部，大小加1，
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            map.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                //如果超过最大容量
                //删去链表尾部节点   并从map中删除
                DoubleLinkedNode tail = removeTail();
                map.remove(tail.key);
            }
        }else {
            //否则直接修改节点的value值即可
            node.value = value;
            //移动到节点头
            moveToHead(node);
        }
    }

    //移动到链表头 = 删除节点+添加到链表头
    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //移除节点
    private void removeNode(DoubleLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    //删除末尾节点
    private DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    //添加到节点头
    private void addToHead(DoubleLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
}
