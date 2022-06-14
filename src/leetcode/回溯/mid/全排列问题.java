package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:  给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @Data: create in 11:33 2021/6/22
 */
public class 全排列问题 {
    // 给定一个不含重复数字的数组 nums
    // 这种写法的问题
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> track = new ArrayList<>();
        trackback(nums,track);
        return res;
    }

    private void trackback(int[] nums, ArrayList<Integer> track) {
        //每次从nums[0]开始遍历 重复元素跳过
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            trackback(nums,track);
            track.remove(track.size()-1);
        }
    }
}
