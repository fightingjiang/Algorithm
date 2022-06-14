import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class test11 {
    public static void main(String[] args) {
        ArrayList<Personxx> list = new ArrayList<>();
        list.add(new Studentxx());
        Vector<Integer> vector = new Vector<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> integers = new HashSet<>();
        integers.iterator();
        HashMap hashMap = new HashMap<Integer,String>();
        Iterator iterator = hashMap.entrySet().iterator();
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);


    }

    public static int fun(){
        int result = 2;
        try {
            result++;
            return result;
        }catch (Exception e){
            return result;
        }finally{
            System.out.println("finally...");
            return result;
        }
    }
}

class Personxx<E>{
    public static void main(String[] args) {
        Personxx<Integer> integerPersonxx = new Personxx<>();
    }
}

class Studentxx extends Personxx{

}