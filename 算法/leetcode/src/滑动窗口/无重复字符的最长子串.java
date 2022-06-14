package 滑动窗口;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    //记录字符 和下标
    HashMap<Character,Integer> window = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = -1;
        for (int i = 0; i < s.length(); i++) {
            if(window.containsKey(s.charAt(i))){
                l = Math.max(l,window.get(s.charAt(i)));
            }
            window.put(s.charAt(i),i);
            res = Math.max(res,i-l);
        }
        return res;
    }
}
