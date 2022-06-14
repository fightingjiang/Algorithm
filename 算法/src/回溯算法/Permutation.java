package 回溯算法;

import java.util.LinkedList;

//全排列
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutation p = new Permutation();
        LinkedList<LinkedList<Integer>> lists = p.permute(nums);
        System.out.println(lists.size());
    }

    //存储最终的结果
    LinkedList<LinkedList<Integer>> res = new LinkedList<>();

    ///* 主函数，输⼊⼀组不重复的数字，返回它们的全排列 */
    public LinkedList<LinkedList<Integer>> permute(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    //回溯算法
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不和法的选择
            if(track.contains(nums[i])){
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一决策树
            backtrack(nums,track);
            //取消选择  回溯
            track.removeLast();
        }
    }
}
