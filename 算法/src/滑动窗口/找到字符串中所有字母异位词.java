package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    //输入:
    //s: "cbaebabacd" p: "abc"
    //
    //输出:
    //[0, 6]
    public static void main(String[] args) {
        System.out.println(new 找到字符串中所有字母异位词().findAnagrams("aa", "bb"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)-'a']++;
        }
        int start = 0,end = 0;
        int[] window = new int[26];
        while (end<s.length()){
            window[s.charAt(end)-'a']++;
            while (end-start+1==p.length()){
                if(Arrays.equals(need,window)) list.add(start);
                window[s.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        return list;
    }
}
