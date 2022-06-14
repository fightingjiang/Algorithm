import java.util.*;

public class test {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        map.put("c","aaaa");
        map.put("b","bbbb");
        map.put("a","cccc");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });


        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }
    }
}
