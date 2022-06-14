package Factory;

public class dog extends Animal{
    @Override
    public void eat() {
        System.out.println("dog吃骨头");
    }

    @Override
    public void speak() {
        System.out.println("dog汪汪汪");
    }
}
