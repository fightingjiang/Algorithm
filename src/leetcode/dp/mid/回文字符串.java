package leetcode.dp.mid;

import java.util.Scanner;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 18:24 2021/7/8
 */
public class 回文字符串 {
    public static int fun(String str){
        if(str==null||str.length()==0) return 0;
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[i][i] = 1;
        }
        for(int j = 1;j<str.length();j++){
            for(int i = j-1;i>=0;i--){
                if(str.charAt(i)==str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][str.length()-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(fun(str.toLowerCase()));
    }
}
