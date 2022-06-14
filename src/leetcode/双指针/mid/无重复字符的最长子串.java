package leetcode.双指针.mid;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ansMax = 0;
        int slow = -1,fast = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast);
            ansMax = Math.max(ansMax,fast-slow);
        }
        return ansMax;
    }
}
