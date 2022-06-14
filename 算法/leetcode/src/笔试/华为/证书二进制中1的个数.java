package 笔试.华为;

import java.util.Scanner;

public class 证书二进制中1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int res = 0;
            while (n>0){
                if((n&1)>0){
                    res++;
                }
                //>>>无符号右移
                n = n>>>1;
            }
            System.out.println(res);
        }
    }
}
