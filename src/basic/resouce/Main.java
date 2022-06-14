package basic.resouce;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i = i+1) {
            list.remove(i);
            System.out.println(list.size());
        }
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
