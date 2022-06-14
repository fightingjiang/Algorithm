package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 *          给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *          candidates 中的数字可以无限制重复被选取。
 *
 * @Data: create in 19:39 2021/6/22
 */
public class 组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        ArrayList<Integer> track = new ArrayList<>();
        trackback(candidates,track,target,0,n);
        return res;
    }

    private void trackback(int[] nums, ArrayList<Integer> track, int target,int start, int n) {
        //防止重复的集合
        if(target==0){
            res.add(new ArrayList<>(track));
        }
        for (int i = start; i < n; i++) {
            //减枝  否则会超时
            if(target-nums[i]<0){
                break;
            }
            track.add(nums[i]);
            trackback(nums,track,target-nums[i],i,n);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> lists = new 组合总和().combinationSum(nums, 7);
        for (List list:lists) {
            System.out.println(list.toString());
        }
    }
}
