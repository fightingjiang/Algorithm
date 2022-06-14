package Observer.ObserverTest;

public interface observer {
    public void update();
}

class trap implements observer{

    @Override
    public void update() {
        System.out.println("trap the hero");
    }
}

class monster implements observer{

    @Override
    public void update() {
        System.out.println("monster eat the hero");
    }
}
