import java.util.Scanner;

public class csp20150901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            if(nextInt!=a){
                a = nextInt;
                sum++;
            }
        }
        System.out.println(sum);
    }
}
