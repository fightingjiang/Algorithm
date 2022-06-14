package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:58 2021/6/22
 */
public class 全排列问题2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> track = new ArrayList<>();
        int[] visited = new int[nums.length];
        trackBack(nums,track,visited);
        return res;
    }

    private void trackBack(int[] nums, ArrayList<Integer> track, int[] visited) {
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]==1||(i>0&&(nums[i-1]==nums[i]&&visited[i-1]==1))){
                continue;
            }
            track.add(nums[i]);
            visited[i]=1;
            trackBack(nums,track,visited);
            track.remove(track.size()-1);
            visited[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> lists = new 全排列问题2().permuteUnique(nums);
        for (List<Integer> list :
                lists) {
            System.out.println(list.toString());
        }
    }
}
