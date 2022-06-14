package Observer;

public class Main {

//    Observer向subject中的observerList中注册，subject发生变化时激活observer的update方法
    public static void main(String[] args) {
        hero hero = new hero();
        hero.addObserver(new trap());
        hero.addObserver(new Monster());
        hero.addObserver(new Treasure());
        hero.move();
    }
}
