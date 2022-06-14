package collections;

import java.util.LinkedList;

public class LruLinkedList {
    private int default_limit;
    private LinkedList<Integer> list = new LinkedList();
    public LruLinkedList() {
        this.default_limit = 3;
    }

    public LruLinkedList(int limit) {
        this.default_limit = limit;
    }

    public void add(Integer num){
        if(list.contains(num)){
            list.remove(num);
        }
        if(list.size()==default_limit){
            list.removeLast();
        }
        list.addFirst(num);
    }

    public void delete(){
        list.removeLast();
    }

    @Override
    public String toString() {
        return "LruLinkedList{" +
                "default_limit=" + default_limit +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {
        LruLinkedList list = new LruLinkedList();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.add(2);
        System.out.println(list.toString());
    }

}
