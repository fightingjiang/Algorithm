package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 *          给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *          candidates 中的每个数字在每个组合中只能使用一次。
 *
 * @Data: create in 12:55 2021/6/22
 */
public class 组合总和2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        ArrayList<Integer> track = new ArrayList<>();
        trackback(candidates,track,target,0,n);
        return res;
    }

    private void trackback(int[] nums, ArrayList<Integer> track, int target, int start, int n) {
        //防止重复的集合
        if(target==0){
            res.add(new ArrayList<>(track));
        }
        for (int i = start; i < n; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            if(target-nums[i]<0){
                break;
            }
            track.add(nums[i]);
            //减枝  否则会超时
            trackback(nums,track,target-nums[i],i+1,n);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new 组合总和2().combinationSum2(nums, 8);
        for (List list:lists) {
            System.out.println(list.toString());
        }
    }
}
