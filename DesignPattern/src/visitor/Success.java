package visitor;

public class Success extends Action{
    @Override
    void getManResult() {
        System.out.println(" man yes");
    }

    @Override
    void getWomanResult() {
        System.out.println("woman yes");
    }
}
