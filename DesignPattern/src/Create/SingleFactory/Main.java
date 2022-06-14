package Create.SingleFactory;

public class Main {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Person person = simpleFactory.createPerson(2);
    }
}
