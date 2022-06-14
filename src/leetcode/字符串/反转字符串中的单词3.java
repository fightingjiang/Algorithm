package leetcode.字符串;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 19:37 2021/7/11
 */
public class 反转字符串中的单词3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(reverse(words[i])+" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private String reverse(String word) {
        char[] res = word.toCharArray();
        int l=0,r = word.length()-1;
        while (l<r){
            char c = res[l];
            res[l] = res[r];
            res[r] = c;
            l++;
            r--;
        }
        return String.valueOf(res);
    }
}
