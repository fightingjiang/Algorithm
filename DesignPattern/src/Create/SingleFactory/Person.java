package Create.SingleFactory;

public interface Person {
}

class Student implements Person{
    static {
        System.out.println("student");
    }
}

class Teacher implements Person{
    static {
        System.out.println("teacher");
    }
}

class Police implements Person{
    static {
        System.out.println("police");
    }
}