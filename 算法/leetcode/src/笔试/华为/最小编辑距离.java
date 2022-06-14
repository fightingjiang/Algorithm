package 笔试.华为;


import java.util.Scanner;

public class 最小编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int len1 = s1.length();
            int len2  =s2.length();
            int[][] dp = new int[len1+1][len2+1];
            for (int i = 0; i <= len1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= len2; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= len1 ; i++) {
                for (int j = 1; j <=len2 ; j++) {
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                    }
                }
            }
            System.out.println(dp[len1][len2]);

        }

    }
}
