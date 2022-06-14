import java.util.Scanner;

public class csp20160901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int max = -1;
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max,Math.abs(nums[i+1]-nums[i]));
        }
        System.out.println(max);
    }
}
