package 笔试选择题;

public class 多态 {
    public static void main(String[] args) {
        A1 b1 = new B2();
        b1.fun();
    }
}

//接口
interface A1{
    void fun();
}

class B1 implements A1{
    @Override
    public void fun() {
        System.out.println("B1");
    }
}

class B2 implements A1{
    @Override
    public void fun() {
        System.out.println("B2");
    }
}
