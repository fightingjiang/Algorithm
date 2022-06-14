package Tree;

public class InClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = new Person();
        Class<? extends Person> Class = person.getClass();
        Person person1 = Class.newInstance();
        System.out.println(person==person1);


        java.lang.Class<?> aClass = null;
        try {
            aClass = java.lang.Class.forName("Tree.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person o = (Person) aClass.newInstance();

    }
}
