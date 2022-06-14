package Factory;

//根据传入参数返回相应的类   不符合开放封闭原则
public class SimpleFactory {
    public Animal getAnimal(String str ){
        if("dog".equals(str)){
            return new dog();
        }else {
            return new cat();
        }
    }

    public static void main(String[] args) {
        Animal animal = new SimpleFactory().getAnimal("cat");
        animal.eat();
        animal.speak();

    }
}
