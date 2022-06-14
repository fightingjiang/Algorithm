package basic.nomal;

public class Person {
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    private String getName(){
        return name;
    }

    final int getAge(){
        return age;
    }

    public void eat(){
        System.out.println("eating");
    }
}
