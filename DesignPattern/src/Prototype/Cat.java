package Prototype;

import java.io.Serializable;

public class Cat implements Cloneable, Serializable {
    String name;
    String color;
    int age;
    Sheep friend =  new Sheep("jack","yellow",2);

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
