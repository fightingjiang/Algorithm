import java.util.Scanner;

public class csp20160401 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 1; i < n-1 ; i++) {
            if((nums[i-1]<nums[i]&&nums[i+1]<nums[i])||(nums[i-1]>nums[i]&&nums[i+1]>nums[i])){
                result++;
            }
        }
        System.out.println(result);

    }
}
