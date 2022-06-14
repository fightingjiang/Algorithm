package 滑动窗口;

import sun.security.util.Length;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 最小覆盖子串_01 {
    public static void main(String[] args) {
        String s = new 最小覆盖子串_01().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
    HashMap<Character,Integer> ori = new HashMap<>();
    HashMap<Character,Integer> cnt = new HashMap<>();
    public String minWindow(String s,String t){
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            ori.put(t.charAt(i),ori.getOrDefault(t.charAt(i),0)+1);
        }
        int res = Integer.MAX_VALUE;
        int l = 0,r = -1;
        int ansL = -1,ansR = -1;
        int slen = s.length();
        while (r<slen){
            r++;
            if(r<slen&&ori.containsKey(s.charAt(r))){
                System.out.println(s.charAt(r));
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while (check()&&l<=r){
                if(r-l+1<res){
                    res = r-l+1;
                    ansL = l;
                    ansR = l+res;
                }
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                //窗口指针右滑
                System.out.println("----");
                l++;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }

    private boolean check() {
        for (Map.Entry<Character,Integer> entry:ori.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(cnt.getOrDefault(key,0)<value){
                return false;
            }
        }
        return true;
    }
}
