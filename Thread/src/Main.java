public class Main {
    public static void main(String[] args) {
        client client1 = new client();
        for(int i=0;i<10;i++){
            new Thread(client1).start();
        }
        System.out.println(Thread.currentThread());



    }
}
