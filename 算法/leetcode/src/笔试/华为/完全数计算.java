package 笔试.华为;

import java.util.Scanner;

public class 完全数计算 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if(n<6){
                System.out.println(0);
                continue;
            }
            int res = 0;
            for (int i = 6; i <= n; i++) {
                int x = i;
                int tmp = 0;
                for (int j = 1; j < x; j++) {
                    if(x%j==0){
                        tmp+=j;
                    }
                }
                if(tmp==x){
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
