package 回溯算法;


import java.util.ArrayList;
import java.util.LinkedList;

public class stringPermutation {
    public static void main(String[] args) {
        String s = "abc";
        String[] strings = new stringPermutation().permutation(s);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }


    LinkedList<String> res = new LinkedList<>();
    public String[] permutation(String s){
        LinkedList<Character> track = new LinkedList<>();
        //记录路径
        backtrack(track,s);
        String[] result = new String[res.size()];
        return  res.toArray(new String[res.size()]);
    }

    private void backtrack( LinkedList<Character> track, String s) {
        //先写结束条件
        if(track.size()==s.length()){
            res.add(String.valueOf(track));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(track.contains(ch)){
                continue;
            }
            //选择路径
            track.add(ch);
            //进入下一决策树
            backtrack(track,s);
            //取消选择
            track.removeLast();

        }
    }
}
