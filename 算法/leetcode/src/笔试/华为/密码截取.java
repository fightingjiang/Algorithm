package 笔试.华为;


import java.util.Scanner;

public class 密码截取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int res = 0;
            int index = 0;
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if(s.charAt(i)!=s.charAt(j)){
                        dp[i][j] = false;
                    }else {
                        if(j-i<3){
                            dp[i][j] = true;
                        }else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j]&&j-i+1>res){
                        res = j-i+1;
                        index = i;
                    }
                }
            }
            System.out.println(res);
        }


    }
}
