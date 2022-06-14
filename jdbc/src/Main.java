public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("D:\\桌面\\algorithm\\jdbc\\src\\reflect.java");
        reflect test = (reflect)aClass.newInstance();
        test.fun();

    }
}
