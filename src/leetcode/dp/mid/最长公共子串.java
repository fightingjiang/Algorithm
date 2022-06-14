package leetcode.dp.mid;


/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:00 2021/7/8
 */
public class 最长公共子串 {
    public String LCS (String str1, String str2) {
        if(str1==null||str1.length()==0||str2==null||str2.length()==0) return "-1";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        int index = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j]>max){
                    max = dp[i][j];
                    index = i;
                }
            }
        }
        return str1.substring(index-max,index);
    }


    //双指针
    public String LCS1 (String str1, String str2) {
        String res = "";
        int start = 0;
        int end = 1;
        while (end<=str2.length()){
            String sub = str2.substring(start,end);
            if(str1.contains(sub)){
                res = sub;
            }else {
                start++;
            }
            end++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new 最长公共子串().LCS("1234", "12"));
    }
}
