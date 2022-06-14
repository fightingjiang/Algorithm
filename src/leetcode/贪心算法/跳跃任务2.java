package leetcode.贪心算法;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:45 2021/7/5
 */
public class 跳跃任务2 {
    public int canJump(int[] nums) {
        if(nums.length<=1||nums==null) return 0;
        int n = nums.length;
        int ans = 0;
        int maxDistance = nums[0];
        for (int i = 0; i < n; i++) {
            ans++;
            int tmp = maxDistance;
            while (i<=tmp&&i<n){
                maxDistance = Math.max(i+nums[i],maxDistance);
                i++;
            }
            if(maxDistance>n-1) return ans;
        }
        return ans;
    }
}
