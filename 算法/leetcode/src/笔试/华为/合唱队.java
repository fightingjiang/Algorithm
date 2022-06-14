package 笔试.华为;


import java.util.Arrays;
import java.util.Scanner;

public class 合唱队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(split[i]);
            }
            //最长递增子序列长度
            int[] dp1 = new int[n];
            //最长递减子序列长度
            int[] dp2 = new int[n];
            Arrays.fill(dp1,1);
            Arrays.fill(dp2,1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i]>nums[j]) dp1[i] = Math.max(dp1[i],dp1[j]+1);
                }
            }
            for (int i = n-2; i >=0 ; i--) {
                for (int j = i+1; j <n; j++) {
                    if(nums[i]>nums[j]) dp2[i] = Math.max(dp2[i],dp2[j]+1);
                }
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res,dp1[i]+dp2[i]-1);
            }
            System.out.println(n-res);

        }

    }
}
