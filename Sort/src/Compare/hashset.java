package Compare;

import java.util.*;

public class hashset {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("jiang",21));
        treeSet.add(new Person("zhihao",33));
        treeSet.add(new Person("zhihao",44));
        treeSet.add(new Person("jiang",19));
        Iterator<Person> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        String[] strings =  new String[5];
        strings[0] = "a";
        strings[1] = "b";
        strings[2] = "v";
        strings[3] = "q";
        strings[4] = "z";
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.asList(strings));
    }
}
