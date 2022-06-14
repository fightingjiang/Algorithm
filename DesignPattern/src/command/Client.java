package command;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new Receive("kongtiao"));
        invoker.open();
        invoker.close();
    }
}
