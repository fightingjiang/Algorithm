package Observer;

public interface Observer {
    public void update();
}

class trap implements Observer{

    @Override
    public void update() {
        if(inRange()){
            System.out.println("Trap trap the hero");
        }
    }

    private boolean inRange() {
        return true;
    }
}

class Monster implements Observer{

    @Override
    public void update() {
        System.out.println("Monster eat the hero");
    }
}

class Treasure implements Observer{

    @Override
    public void update() {
        System.out.println("Treasure help the hero ");
    }
}