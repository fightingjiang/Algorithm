import java.util.Scanner;

public class csp20171201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                min = Math.min(min,Math.abs(data[i]-data[j]));
            }
            if(min==0){
                break;
            }
        }
        System.out.println(min);
    }
}
