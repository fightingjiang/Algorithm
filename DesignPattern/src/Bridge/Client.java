package Bridge;

public class Client {
    public static void main(String[] args) {
        FoldedPhone xiaomi1 = new FoldedPhone(new Xiaomi());
        xiaomi1.open();
        xiaomi1.call();
        xiaomi1.close();

        System.out.println("---------------");

        FoldedPhone vivo1 = new FoldedPhone(new Vivo());
        vivo1.open();
        vivo1.call();
        vivo1.close();
    }
}
