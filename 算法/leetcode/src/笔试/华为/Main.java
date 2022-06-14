package 笔试.华为;


public class Main {
    public static void main(String[] args) {
        int x = 4;
        String s = Integer.toString(x, 2);
        while (s.length()<4){
            s = "0"+s;
        }
        System.out.println(s);
        String s1 = new StringBuilder(s).reverse().toString();
        System.out.println(s1);
        System.out.println(Integer.toString(Integer.parseInt(s1,2),16));
    }

}
