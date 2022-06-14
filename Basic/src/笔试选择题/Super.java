package 笔试选择题;

public class Super {
    public static void main(String[] args) {
        new C().fun1();
    }
}

class P{
    void fun(){
        System.out.println("fun");
    }
}

class C extends P{
    void fun1(){
        super.fun();
    }
}