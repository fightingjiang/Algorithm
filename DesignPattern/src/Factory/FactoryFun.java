package Factory;

public class FactoryFun {
    public static void main(String[] args) {
        dogFactory dogFactory = new dogFactory();
        catFactory catFactory = new catFactory();
        Animal animal1 = dogFactory.createAnimal();
        animal1.eat();
        Animal animal = catFactory.createAnimal();
        animal.eat();
    }
}


interface animalFactory{
    Animal createAnimal();
}

class dogFactory implements animalFactory{

    @Override
    public Animal createAnimal() {
        return new dog();
    }
}

class catFactory implements animalFactory{

    @Override
    public Animal createAnimal() {
        return new cat();
    }
}