import java.util.Scanner;

public class csp20151202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] result = new int[n][m];
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = scanner.nextInt();
                nums[i][j] = result[i][j];
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j < m-1; j++) {
                if(nums[i][j]==nums[i][j-1]&&nums[i][j]==nums[i][j+1]){
                    result[i][j] = 0;
                    result[i][j-1] = 0;
                    result[i][j+1] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n-1; j++) {
                if(nums[j][i]==nums[j-1][i]&&nums[j][i]==nums[j+1][i]){
                    result[j][i] = 0;
                    result[j-1][i] = 0;
                    result[j+1][i] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}
