package Prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

public class Sheep implements Cloneable, Serializable {
    String name ;
    String color;
    int age;
    Cat friend;

    public Sheep(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //浅拷贝
//        return super.clone();

        //深拷贝  多层嵌套都需要重新克隆
        Object clone = super.clone();
        Sheep sheep = (Sheep) clone;
        sheep.friend = (Cat) friend.clone();
        return sheep;
    }

    //深拷贝推荐使用
    public Sheep deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//将this对象以byte流形式写出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Sheep sheep = (Sheep) ois.readObject();
            return sheep;

        } catch (Exception e) {
            System.out.println("1");
            e.printStackTrace();
            return null;
        } finally{
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                System.out.println("3");
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
