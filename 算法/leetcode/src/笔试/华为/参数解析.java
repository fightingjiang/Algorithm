package 笔试.华为;

import java.util.ArrayList;
import java.util.Scanner;

public class 参数解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            int len = 0;
            int index = 0;
            if(s.charAt(i)==34){
                i++;
                index = i;
                while (i<s.length()&&s.charAt(i)!=34){
                    len++;
                    i++;
                }
                i++;
                list.add(s.substring(index,index+len));
            }else if(s.charAt(i)==' '){
                i++;
            }else {
                index = i;
                while (i<s.length()&&s.charAt(i)!=' '){
                    len++;
                    i++;
                }
                list.add(s.substring(index,index+len));
            }
        }
        System.out.println(list.size());
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }
}
