import java.util.Scanner;

public class csp20170301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = 0;
        int now = 0;
        for (int i = 0; i < n ; i++) {
            now+=a[i];
            if(now>=k){
                result++;
                now = 0;
            }
        }
        if(now>0){
            result++;
        }
        System.out.println(result);
    }
}
