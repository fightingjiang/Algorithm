package 回溯算法;

import java.util.ArrayList;

public class 组合 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subset = new 组合().combine(4,2);
        for (ArrayList<Integer> list: subset
        ) {
            System.out.println(list.toString());
        }
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int n ,int k){
        trackback(n,k,1);
        return res;
    }

    private void trackback(int n, int k,int start) {
        if(track.size()==k){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            trackback(n,k,i+1);
            track.remove(track.size()-1);
        }
    }
}
