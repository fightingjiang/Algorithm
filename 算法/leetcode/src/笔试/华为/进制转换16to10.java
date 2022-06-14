package 笔试.华为;

import java.util.Scanner;

public class 进制转换16to10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine().toUpperCase();
            int res = 0;
            for (int i = 2;i <s.length(); i++) {
                char c = s.charAt(i);
                int n = 0;
                if(Character.isDigit(c)){
                    n = c-'0';
                }else{
                    n = c-'A'+10;
                }
                res = res*16+n;
            }
            System.out.println(res);
        }
    }
}
