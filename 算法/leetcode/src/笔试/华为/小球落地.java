package 笔试.华为;


import java.util.Scanner;

public class 小球落地 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        double l = d;
        double h = d;
        for (int i = 0; i < 5; i++) {
            h = h/2;
            l = l+2*h;
        }
        l = l-2*h;
        System.out.printf("%.6f",l);
        System.out.println();
        System.out.printf("%.6f",h);
    }
}
