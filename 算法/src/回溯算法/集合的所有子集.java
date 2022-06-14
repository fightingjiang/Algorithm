package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;

public class 集合的所有子集 {
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        ArrayList<ArrayList<Integer>> lists = new 集合的所有子集().subsets(S);
//        for (int i = 0; i < lists.size(); i++) {
//            System.out.println(lists.get(i).toString());
//        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
//        if(S==null||S.length==0) return new ArrayList<ArrayList<Integer>>();
        LinkedList<Integer> track = new LinkedList<>();
        trackback(S,0,track);
        return res;
    }

    private void trackback(int[] s, int start, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < s.length ; i++) {
            //做选择
            track.add(s[i]);
            //回溯
            trackback(s,i+1,track);
            //撤销选择
            track.removeLast();
        }
    }
}
