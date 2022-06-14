import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapCache<K,V> extends LinkedHashMap<K,V> {
    private static final int capacity = 8;

    public LinkedHashMapCache() {
        super(capacity,0.75f,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {
        LinkedHashMapCache<Integer, Integer> cache = new LinkedHashMapCache<>();
        for (int i = 0; i < 10; i++) {
            cache.put(i,i);
        }
        cache.get(2);
        cache.get("num4");
        Iterator<Map.Entry<Integer, Integer>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }

    }
}
