import java.util.*;

public class LRUCache<k,v> extends LinkedHashMap{
    public LRUCache() {
        super(max,0.75f,true);
    }
    private static final int max = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>max;
    }

    public static void main(String[] args) {
        LRUCache<Integer,String> cache = new LRUCache();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        Object o = new Object();
    }
}
