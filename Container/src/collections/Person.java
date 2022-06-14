package collections;


import java.util.ArrayList;
import java.util.Collections;

//年龄大小排序
/*
        Comparable 接口

 */
public class Person implements Comparable<Person> {
    int age;
    String name;
    String school;

    public Person(int age, String name, String school) {
        this.age = age;
        this.name = name;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if(age>o.age){
            return 1;
        }else if(age<o.age){
            return -1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(20,"daxue","nau"));
        persons.add(new Person(18,"hight school","yizhong"));
        persons.add(new Person(24,"yanjiush","hnu"));
        for (Person person: persons
             ) {
            System.out.println(person.toString());
        }
        Collections.sort(persons);
        for (Person person: persons
        ) {
            System.out.println(person.toString());
        }
    }
}
