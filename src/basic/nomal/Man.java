package basic.nomal;

public class Man extends Person{

    public Man(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("man sating ");
    }

}
