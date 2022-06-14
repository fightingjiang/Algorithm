package 回溯算法;

import java.util.LinkedList;

//数字的全排列
//全排列
public class Permutation01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutation01().permute(nums).toString());
    }

    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    public LinkedList<LinkedList<Integer>> permute(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track,nums);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums) {
        //结束条件
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //排除不合规在的选择
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一决策树
            backtrack(track,nums);
            //取消选择
            track.removeLast();
        }
    }
}
