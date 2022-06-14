package Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class student{
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<student> students = new ArrayList<>();
        students.add(new student("jiang",19));
        students.add(new student("zhihao",20));
        students.add(new student("su",48));
        students.add(new student("su",30));
        students.add(new student("su",11));
        students.add(new student("su",2));
        Collections.sort(students, new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                int i = o1.name.compareTo(o2.name);
                if(i==0){
                    return o1.age-o2.age;
                }else {
                    return i;
                }
            }
        });
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
