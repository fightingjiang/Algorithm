import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Cache {
    public static LinkedHashMap<Integer,String> linkedHashMap = new MyLinkedHashMap(5);



    public  static String db(Integer integer ) {

        String data = "data"+integer;
        putCache(integer,data);
        return data;
    }

    public  static String get(Integer integer){
        if(linkedHashMap.get(integer)==null){
            return db(integer);
        }else{
            return linkedHashMap.get(integer);
        }
    }

    public  static void  putCache(Integer integer,String data){
        linkedHashMap.put(integer,data);
    }

    public static void main(String[] args) {

        get(1);
        get(2);
        get(3);
        get(4);
        get(5);
        get(6);
        get(7);
        get(1);
        System.out.println(linkedHashMap.toString());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()+"   "+get(1));

        System.out.println(System.currentTimeMillis()+"   "+get(1));
    }
}

class MyLinkedHashMap extends LinkedHashMap{
    private int capacity;

    public MyLinkedHashMap(int capacity) {
        this.capacity = capacity;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>capacity;
    }
}
