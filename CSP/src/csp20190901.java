import java.util.Scanner;

public class csp20190901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//3
        int n = scanner.nextInt();//3
        int sum = 0;
        int max = 1;
        int maxIndex = -1;
        for (int i  = 1; i <=m ; i++) {
            int del=0;
            int before = 0;
            int after = 0;
            before = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                del = del+scanner.nextInt();
            }
            after = before+del;
            sum+=after;
            if(del<max){
                max = del;
                maxIndex = i;
            }
        }
        System.out.println(sum+" "+maxIndex+" "+Math.abs(max));
    }

}
/*
3 3
73 -8 -6 -4
76 -5 -10 -8
80 -6 -15 0


 */