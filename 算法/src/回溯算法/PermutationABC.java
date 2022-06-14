package 回溯算法;

import java.util.LinkedList;
import java.util.List;

public class PermutationABC {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new PermutationABC().permutation(s).toString());
    }

    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
//        LinkedList<Character> track = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        trackback(track,s);
        return res.toArray(new String[res.size()]);
    }

    private void trackback(StringBuilder track, String str) {
        if(track.length()==str.length()){
            res.add(track.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //路径排除
            if(track.toString().contains(ch+"")){
                continue;
            }
            //选择路径
            track.append(ch);
            //进入下一决策树
            trackback(track,str);
            //撤销选择
            track.deleteCharAt(track.length()-1);
        }
    }


}
