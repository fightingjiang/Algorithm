package 原型模式克隆;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        CLone1 cLone1 = new CLone1();
        CLone1 clone = (CLone1)cLone1.clone();
        cLone1.name = "sjs";
        cLone1.clone2 = new Clone2(10);
        System.out.println(clone.name);
        System.out.println(clone.clone2.age);
    }
}

class CLone1 implements Cloneable{
    String name = "jzh";
    int age = 10;
    Clone2 clone2 = new Clone2(2);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Clone2{
    int age;

    public Clone2(int age) {
        this.age = age;
    }
}