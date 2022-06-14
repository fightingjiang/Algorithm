import java.util.Scanner;

public class csp20140301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] hash = new int[1001];
        for (int i = 0; i < N; i++) {
            int nextInt = scanner.nextInt();
            hash[Math.abs(nextInt)]++;
        }
        int sum = 0;
        for (int i = 0; i < hash.length-1; i++) {
            if(hash[i]>=2){
                sum++;
            }
        }
        System.out.println(sum);
    }
}
