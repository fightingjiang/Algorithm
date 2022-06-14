package 回溯算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 加起来和为目标值的算法 {
    public static void main(String[] args) {
        int[] nums = {100,10,20,70,60,10,50};
        System.out.println(new 加起来和为目标值的算法().combinationSum2(nums, 80));
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if(num == null || num.length==0 || target<0)return res;
        Arrays.sort(num);
        trackback(num,target,0);
        return res;
    }

    private void trackback(int[] num, int target, int start) {
        if(target==0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if(start>=num.length) return;
        if(target<0) return;
        for (int i = start; i < num.length ; i++) {
            if(i>start&&num[i]==num[i-1]) continue;
            track.add(num[i]);
            trackback(num,target-num[i],i+1);
            track.remove(track.size()-1);
        }
    }
}
