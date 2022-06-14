package command;

public class Receive {
    private String name;

    public Receive(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receive{" +
                "name='" + name + '\'' +
                '}';
    }
}
