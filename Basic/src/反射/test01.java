package 反射;

public class test01{
    public static void main(String[] args) throws Exception {
/*        Class<TestRf> rfClass = TestRf.class;
        TestRf testRf = rfClass.newInstance();
        System.out.println(testRf.name);
        Constructor<?>[] constructors = rfClass.getConstructors();
        for (Constructor co: constructors
             ) {
            System.out.println(co);
        }
        Constructor<?>[] cons = rfClass.getDeclaredConstructors();
        for (Constructor co: cons
        ) {
            System.out.println(co);
        }
        Constructor<TestRf> constructor = rfClass.getDeclaredConstructor(int.class);
        TestRf testRf1 = constructor.newInstance(20);
        System.out.println(testRf1.name+"   "+testRf1.age);*/

        TestRf testRf = new TestRf();
        Class<? extends TestRf> clazz1 = testRf.getClass();
        Class<TestRf> clazz2 = TestRf.class;
        System.out.println(clazz1==clazz2);

    }
}


class TestRf{
    static int name = 101;
    int age = 22;

    public TestRf(int name) {
        this.name = name;
    }

    public TestRf(int name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestRf() {
    }

    public void fun(){
        System.out.println("wucan");
    }

    public void fun(int age){
        System.out.println("you age canshu");
    }

    public void fun(String name){
        System.out.println("you name");
    }
}