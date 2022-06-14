import java.util.Scanner;

public class csp20150302 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[1001];
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            nums[value]++;
        }
        int max = -1;
        int index =-1;
        for (int j = 0; j< n ; j++) {
            for (int i = 0; i < 1001; i++) {
                if(nums[i]!=0&&nums[i]>max){
                    max = nums[i];
                    index = i;
                }
            }
            if(max!=-1){
                System.out.println(index+" "+nums[index]);
                nums[index] = 0;
                index =-1;
                max = -1;
            }
        }
    }
}
