import java.util.Arrays;
import java.util.Scanner;

public class csp20180302_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int t =scanner.nextInt();
        int[] location = new int[n + 2];
        location[0] = 0;
        location[n+1] = L;
        int[] v =new int[n+2];
        for (int i = 0; i < v.length; i++) {
            v[i] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            location[i] = scanner.nextInt();
        }
        for (int i = 0; i < t; i++) {
            for (int j = 1; j <n+1 ; j++) {
                location[j] = location[j]+v[j];
            }
            for (int j = 1; j < n+1; j++) {
                for (int k = 0; k < n+2; k++) {
                    if(j!=k&&location[j]==location[k]){
                        v[j] = -v[j];
                    }
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            System.out.print(location[i]+" ");
        }

    }
}
/*



sdjaikjwhdalwjdioada



 */