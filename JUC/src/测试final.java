public class 测试final {
    public static void main(String[] args) {
        String s = "jzh";
        String intern = s.intern();
        System.out.println(s);
        s = s+"jiayou";
        String intern1 = s.intern();
        System.out.println(s);
        System.out.println(intern==intern1);
    }
}
