package command;

public class ConcreteCommand implements Command {

    private Receive receive;

    public ConcreteCommand(Receive receive) {
        this.receive = receive;
    }

    @Override
    public void execute() {
        System.out.println("open ..."+receive.toString());
    }

    @Override
    public void undo() {
        System.out.println("close ..."+receive.toString());

    }
}
