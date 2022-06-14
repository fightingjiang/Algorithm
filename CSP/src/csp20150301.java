import java.util.Scanner;

public class csp20150301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =scanner.nextInt();
        scanner.nextLine();
        int[][] nums = new int[n][m];
        for (int i = 0; i <n ; i++) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[j][i]+" ");
            }
            System.out.println();
        }

    }
}
