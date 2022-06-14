
public class 简单题目 {
    public static void main(String[] args) {
        String[] strs = {"abcc","abcc","abcb"};
        System.out.println(longestCommonPrefix(strs));
    }
    //最长公共前缀
    public static String longestCommonPrefix (String[] strs) {
        if(strs==null||strs.length==0) return "";
        int Minlen = strs[0].length();
        for (String str:strs
             ) {
            Minlen = Math.min(str.length(),Minlen);
        }
        int len = 0;
        for (int i = 0; i < Minlen; i++) {
            boolean flag =false;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i)!=ch){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            len++;
        }
        if(len==0) return "";
        else{
            return strs[0].substring(0,len);
        }
    }
}
