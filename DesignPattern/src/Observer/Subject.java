package Observer;

import java.util.ArrayList;
import java.util.List;

abstract public class Subject {
    private List<Observer> observerList = new ArrayList<Observer>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObserver(){
        for (Observer observer:observerList
             ) {
            observer.update();
        }
    }

}
class hero extends Subject{
    void move(){
        notifyObserver();
    }
}
