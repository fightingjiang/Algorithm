package Compare;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("jiang",19));
        list.add(new Person("zhihao0",18));
        list.add(new Person("su",12));
        list.add(new Person("su",15));
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }
}
