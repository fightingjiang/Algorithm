package leetcode.贪心算法;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:45 2021/7/5
 */
public class 跳跃任务 {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i<=maxDistance){
                maxDistance = Math.max(maxDistance,i+nums[i]);
                if(maxDistance>=nums.length-1) return true;
            }
        }
        return false;
    }
}
