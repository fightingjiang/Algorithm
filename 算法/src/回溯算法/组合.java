package 回溯算法;

import java.util.ArrayList;
import java.util.LinkedList;

//[1...n] 中k个数字的组合
public class 组合 {
    public static void main(String[] args) {
        new 组合().combine(4,2);
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n,int k){
        LinkedList<Integer> track = new LinkedList<>();
        trackback(n,k,1,track);
        return res;
    }

    private void trackback(int n, int k, int start, LinkedList<Integer> track) {
        if(k==track.size()){
            res.add(new ArrayList<>(track));
            System.out.println(track.toString());
            return;
        }
        for (int i = start; i <= n ; i++) {
            track.add(i);
            trackback(n,k,i+1,track);
            track.removeLast();
        }
    }
}
