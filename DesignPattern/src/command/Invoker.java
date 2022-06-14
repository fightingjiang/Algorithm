package command;

public class Invoker {
    private Command command;

    public Invoker(Receive receive) {
        command = new ConcreteCommand(receive);
    }

    public void open() {
        command.execute();
    }

    public void close(){
        command.undo();
    }
}
