package Observer.ObserverTest;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    public List<observer> list = new ArrayList<>();

    public void add(observer observer){
        list.add(observer);
    }

    public void remove(observer observer){
        list.remove(observer);
    }

    public void notifyObserver(){
        for (observer observer : list) {
            observer.update();
        }
    }
}

class hero extends Subject{
    public void move(){
        notifyObserver();
    }
}
