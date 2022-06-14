package leetcode.字符串;

import java.util.HashMap;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:49 2021/7/23
 */
public class 最长无重复字符字串 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        int left = -1;
        int ansMax = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c));
            }
            map.put(c,i);
            ansMax = Math.max(ansMax,i-left);
        }
        return ansMax;
    }
}
