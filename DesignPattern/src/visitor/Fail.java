package visitor;

public class Fail extends  Action{
    @Override
    void getManResult() {
        System.out.println("man no ");
    }

    @Override
    void getWomanResult() {
        System.out.println("woman no");
    }
}
