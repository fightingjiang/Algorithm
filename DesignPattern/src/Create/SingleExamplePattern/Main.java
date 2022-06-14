package Create.SingleExamplePattern;

public class Main {
    public static void main(String[] args) {
        Singleton uniqueInstance1 = Singleton.getUniqueInstance();
        Singleton uniqueInstance2 = Singleton.getUniqueInstance();
        System.out.println(uniqueInstance1==uniqueInstance2);
    }
}
