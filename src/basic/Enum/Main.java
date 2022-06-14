package basic.Enum;

public class Main {
    public static void main(String[] args) {
        for (Color c: Color.values()
             ) {
            System.out.println(c+"index at: "+c.ordinal());
            c.print();
        }
        Color red = Color.valueOf("red");
        System.out.println(red);
    }
}
