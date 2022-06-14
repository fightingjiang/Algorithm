import java.util.HashMap;
import java.util.Scanner;

public class csp20141201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!hash.containsKey(nums[i])){
                hash.put(nums[i],1);
                System.out.print(1+" ");
            }else {
                Integer integer = hash.get(nums[i]);
                integer++;
                hash.put(nums[i],integer);
                System.out.print(integer+" ");
            }
        }
    }
}
