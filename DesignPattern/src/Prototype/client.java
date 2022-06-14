package Prototype;

public class client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("Tom", "white", 10);
        sheep.friend = new Cat("jack","black",2);
        Sheep sheep1 = (Sheep)sheep.deepClone();
        System.out.print(sheep.hashCode()+"    ");
        System.out.println(sheep.friend.hashCode()+"    "+sheep.friend.friend.hashCode());
        System.out.println(sheep1.hashCode()+"    "+sheep1.friend.hashCode()+"    "+sheep1.friend.friend.hashCode());
    }
}
