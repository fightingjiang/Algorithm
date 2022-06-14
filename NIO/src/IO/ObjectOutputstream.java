package IO;

import java.io.*;

public class ObjectOutputstream {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person person = new Person("jiang", 25);
        oos.writeObject(person);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person1 =(Person) ois.readObject();
        System.out.println(person1.toString());
        ois.close();
    }
}
