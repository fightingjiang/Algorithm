import java.util.Scanner;

public class csp20140902 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int[][] nums = new int[101][101];
        for (int i = 0; i < n; i++) {
            int xl = scanner.nextInt();
            int yl = scanner.nextInt();
            int xr = scanner.nextInt();
            int yr = scanner.nextInt();
            for (int j = xl; j < xr ; j++) {
                for (int k = yl; k < yr; k++) {
                    nums[j][k] = 1;
                }
            }
        }
        for (int j = 0; j <= 100; j++) {
            for (int k = 0; k <= 100; k++) {
                if(nums[j][k]==1){
                    sum++;
                }
            }
        }
        System.out.println(sum);

    }
}
