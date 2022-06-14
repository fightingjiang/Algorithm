package 滑动窗口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 最小覆盖子串 {
    //两个map用来存储  t字符串字符
    HashMap<Character,Integer> ori = new HashMap<>();
    HashMap<Character,Integer> cnt = new HashMap<>();
    public String minWindow(String s,String t){
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        //滑动窗口左右指针
        int l = 0,r = -1;
        //ansL ansR记录结果字符串开始截止位置
        int len = Integer.MAX_VALUE,ansL = -1,ansR = -1;
        int sLen = s.length();
        while (r<sLen){
            //窗口右指针右滑
            ++r;
            if(r<sLen&&ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            //如果当前窗口符合条件
            while (check()&&l<=r){
                if(r-l+1<len){
                    //更新最短长度
                    len = r-l+1;
                    ansL = l;
                    ansR = l+len;
                }
                //如果l所在的挡在位置元素在ori中出现郭  cnt中也要响应减少
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                //窗口左指针右滑
                ++l;
            }
        }
        return ansL==-1?"":s.substring(ansL,ansR);
    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(cnt.getOrDefault(key,0)<val){
                return false;
            }
        }
        return true;
    }
}
