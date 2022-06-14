package 笔试.华为;


import java.util.*;

public class 提取不重复整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = s.length()-1; i >=0; i--) {
            Integer x = Integer.valueOf(s.charAt(i)-'0');
            if(!list.contains(x)){
                list.add(x);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
