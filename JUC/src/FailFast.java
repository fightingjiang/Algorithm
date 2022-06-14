import java.util.ArrayList;
import java.util.Iterator;

public class FailFast {
    static ArrayList<Integer> list  =  new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        new Thread(()->{
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(5);
        }).start();
        while (iterator.hasNext()){
            Thread.sleep(1000);{
                System.out.println(iterator.next());
            }
        }

    }
}

abstract class test01{

}