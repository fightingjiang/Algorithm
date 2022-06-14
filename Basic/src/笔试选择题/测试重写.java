package 笔试选择题;

public class 测试重写 {
    public static void main(String[] args) {
        P1 c1 = new C1();
    }
}

class P1{
    private Object fun(){
        System.out.println("P!");
        return "";
    }
}

class C1 extends P1{
    //子类方法的访问权限必须大于等于父类方法；
    public String fun(){
        System.out.println("C!");
        return "";
    }
}