package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyCache<K,V> extends LinkedHashMap<K,V> implements Comparable{
    private int max_capacity;

    public MyCache(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>max_capacity;
    }

    public static void main(String[] args) {
        TreeMap<Age, Object> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(new Age(i),i);
        }
        System.out.println(treeMap);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Age implements Comparable{
    int age;

    public Age(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Age age1 = (Age) o;
        return -this.age-age1.age;
    }

    @Override
    public String toString() {
        return "Age{" +
                "age=" + age +
                '}';
    }
}
