package 笔试.华为;


import java.util.Scanner;

public class 蛇形举证 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int d = 2;
            int x = 1;
            int x1 = 0;
            for (int i = 0; i < n; i++) {
                int xn = x;
                int dn = d;
                int l = 0;
                for (int j = 0; j < n-i; j++) {
                    System.out.print(xn+" ");
                    xn = xn+dn+j;
                }
                d++;
                x1++;
                x = x+x1;
                System.out.println();
            }
        }

    }
}
