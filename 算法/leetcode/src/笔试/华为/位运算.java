package 笔试.华为;

import java.util.Scanner;

public class 位运算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while (n > 0) {
            if((n&1)>0) res++;
            n = n>>1;
        }
        System.out.println(res);
    }
}
