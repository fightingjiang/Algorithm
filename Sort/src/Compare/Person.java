package Compare;


public class Person implements Comparable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person person = (Person) o;
            int compareTo = this.name.compareTo(person.name);
            if(compareTo==0){
                return this.age-person.age;
            }else {
                return compareTo;
            }
        }else{
            throw new RuntimeException();
        }
    }
}
