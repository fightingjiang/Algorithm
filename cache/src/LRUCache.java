import com.sun.javafx.sg.prism.web.NGWebView;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Node head ;
    private Node end;
    private int limit;
    private HashMap<String,Node> hashMap;


    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<String, Node>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if(node==null){
            return  null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key,String value){
        Node node = hashMap.get(key);
        if(node==null){
            if(hashMap.size()>=limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(key,node);
        }else {
            node.value = value;
            refreshNode(node);
        }
    }



    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    //刷新被访问的节点位置
    public void refreshNode(Node node){
        //查的数据刚好在链表末尾， 时node.end  不做操作
        if(node==end){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    //删除节点
    private String removeNode(Node node){
        if(node==end){
            end = end.pre;
        }else if(node==head){
            head = head.next;
        }else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    //尾部加入节点
    private void addNode(Node node){
        if (end!=null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        //插入第一个节点时
        if(end ==null){
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("01","用户1信息");
        lruCache.put("02","用户2信息");
        lruCache.put("03","用户3信息");
        lruCache.put("04","用户4信息");
        lruCache.get("02");
        lruCache.put("05","用户5信息");
        lruCache.put("06","用户6信息");
        System.out.println(lruCache.get("01"));
        System.out.println(lruCache.get("06"));
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
    }
}
 class Node {
    public Node pre;
    public Node next;
    public String key;
    public String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
