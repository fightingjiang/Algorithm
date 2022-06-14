package leetcode.双指针.mid;

public class 最小长度子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0,left = 0,right = 0;
        while (right<nums.length){
            sum+=nums[right];
            while (sum>=target){
                min = Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new 最小长度子数组().minSubArrayLen(7, nums));
    }
}
