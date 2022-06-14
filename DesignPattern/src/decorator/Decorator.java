package decorator;

public class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }


    @Override
    public float cost() {
        return obj.cost()+super.getPrice();
    }
}
