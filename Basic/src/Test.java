
public class Test {
    public static void main(String[] args) {
        Parent child = new child();
    }
}

class Parent{
    int age;

    public Parent() {
    }

    public Parent(int age) {
        this.age = age;
    }
}

class child extends Parent{

    public child() {
    }

    public child(int age) {
        super(age);
    }
}
