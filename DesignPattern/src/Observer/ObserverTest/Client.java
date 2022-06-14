package Observer.ObserverTest;


public class Client {
    public static void main(String[] args) {
        hero hero = new hero();
        hero.add(new trap());
        hero.add(new monster());
        hero.move();
    }
}
