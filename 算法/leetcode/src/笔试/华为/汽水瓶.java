package 笔试.华为;

import java.util.Scanner;

public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int x = sc.nextInt();
            if(x==0) break;
            int res = 0;
            while (x>=3){
                int tmp = x/3;
                res+=tmp;
                x = tmp+x%3;
            }
            if(x==2) res++;
            System.out.println(res);
        }
    }
}
