package 笔试.华为;


import java.util.Scanner;

public class 立方根 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n  = sc.nextDouble();
        double res = getCubert(n);
        System.out.printf("%.1f",res);
    }

    private static double getCubert(double c) {
        double e = 1e-7;
        double x0 = c;
        double x1 = (2.0*x0+c/(x0*x0))/3;
        while (Math.abs(x1-x0)>e){
            x0 = x1;
            x1 = (2.0*x0+c/(x0*x0))/3;
        }
        return x1;
    }
}
