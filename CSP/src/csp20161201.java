import java.util.Arrays;
import java.util.Scanner;

public class csp20161201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int mid = nums[n/2];
        int low = 0;
        int high = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>mid){
                high++;
            }
            if(nums[i]<mid){
                low++;
            }
        }
        if(low==high){
            System.out.println(mid);
        }else {
            System.out.println(-1);
        }
    }
}
