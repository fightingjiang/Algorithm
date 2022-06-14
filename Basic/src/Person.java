import java.security.PrivateKey;

public interface Person {

    public void eat();

    default void have(){
        System.out.println("aa");
    }
}

abstract class People{
    void fun(){
        System.out.println("people");
    }
}

class female extends People{

}

class man implements Person{

    @Override
    public void eat() {

    }

    @Override
    public void have() {
        System.out.println("student");
    }

    public static void main(String[] args) {
        new man().have();
        new female().fun();
    }
}
