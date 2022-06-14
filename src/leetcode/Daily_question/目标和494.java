package leetcode.Daily_question;

public class 目标和494 {
    //递归
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums,target,nums.length-1);
    }

    private int findTargetSumWays(int[] nums, int target, int i) {
        if(i==-1){
            if(target==0) return 1;
            else return 0;
        }
        return findTargetSumWays(nums,target-nums[i],i-1)+findTargetSumWays(nums,target+nums[i],i-1);
    }

    //动态规划
}
