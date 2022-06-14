import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class csp20140901 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < n; i++) {
            if(nums[i]-nums[i-1]==1){
                result++;
            }
        }
        System.out.println(result);
    }
}
