package 笔试.华为;

import java.util.Scanner;

public class 放苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int res = func(m,n);
            System.out.println(res);
        }
    }

    private static int func(int m, int n) {
        if(n==1||m==0) return 1;
        else if(n>m) return func(m,m);
        else return func(m,n-1)+func(m-n,n);
    }
}
