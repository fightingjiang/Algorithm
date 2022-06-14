package leetcode.字符串;

import java.util.Arrays;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:08 2021/7/11
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder("");
        if(strs==null||strs.length==0) {
            return prefix.toString();
        }
        Arrays.sort(strs);
        int n = strs.length;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            Character tmp = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if(!(strs[j].charAt(i)!=tmp)){
                    return prefix.toString();
                }
            }
            prefix.append(tmp);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new 最长公共前缀().longestCommonPrefix(strs));
    }
}
