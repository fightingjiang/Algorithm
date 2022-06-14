package 笔试.华为;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 走梅花桩 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            int[] nums = new int[n];
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(split[i]);
            }
            int[] dp = new int[n];
            Arrays.fill(dp,1);
            int res = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i]>nums[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                res = Math.max(res,dp[i]);
            }
            System.out.println(res);
        }

    }
}
