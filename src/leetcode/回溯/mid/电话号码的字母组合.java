package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:49 2021/6/26
 */
public class 电话号码的字母组合 {
    static String strs[]  = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0||digits==null) return res;
        StringBuilder track = new StringBuilder();
        trackback(digits,track,0);
        return res;
    }

    private void trackback(String digits, StringBuilder track, int start) {
        if(track.length()==digits.length()){
            res.add(new String(track));
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            String str = strs[digits.charAt(i)-'0'-2];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                track.append(c);
                trackback(digits,track,i+1);
                track.deleteCharAt(track.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new 电话号码的字母组合().letterCombinations("23");
        for (String str: strings
             ) {
            System.out.println(str);
        }
    }
}
