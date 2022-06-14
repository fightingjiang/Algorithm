import java.util.Scanner;

public class csp20170901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0 ;
        sum+=(N/50)*7;
        N = N%50;
        sum+=(N/30)*4;
        N = N%30;
        sum+=(N/10);
        System.out.println(sum);
    }
}
