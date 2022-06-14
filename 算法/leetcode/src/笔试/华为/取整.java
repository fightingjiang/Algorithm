package 笔试.华为;

import java.util.Scanner;

public class 取整 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble()+0.5;
        System.out.println((int) d);
    }
}
