package leetcode.hashTable.mid;

import java.util.HashMap;
import java.util.HashSet;

public class 无重复字符的最长子串3 {
    public int lengthOfLongestSubstring(String s) {
        //"abcabcbb"
        HashSet<Character> map = new HashSet<>();
        int len = 0;
        int fast = 0,slow = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            while (map.contains(c)){
                map.remove(s.charAt(slow));
                slow++;
            }
            map.add(c);
            len = Math.max(len,fast-slow+1);
        }
        return len;
    }

    public int lengthOfLongestSubstring1(String s) {
        //"abcabcbb"
        int fast = 0;
        int slow = -1;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (fast = 0; fast < s.length() ; fast++) {
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c));
            }
            map.put(c,fast);
            res = Math.max(res,fast-slow);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串3().lengthOfLongestSubstring1("abba"));
    }
}
