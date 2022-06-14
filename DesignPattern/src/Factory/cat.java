package Factory;

public class cat extends Animal{
    @Override
    public void eat() {
        System.out.println("cat吃鱼");
    }

    @Override
    public void speak() {
        System.out.println("cat喵喵喵");
    }
}
