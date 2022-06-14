import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 判断回文 {
    public boolean judge(String str) {
        int r = str.length() - 1, l = 0;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

     static public void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);ner.nextInt();
        ArrayList<Object> list = new ArrayList<>();
        String s = "aaa";
        StringBuilder builder = new StringBuilder(s);
        builder.reverse().toString();

               LinkedList<Object> list1 = new LinkedList<>();
        list1.addFirst("abc"+" " );
        list1.addFirst("dad");
        System.out.println(list1.toString());
        System.out.println(String.valueOf(list1));
    }
}
