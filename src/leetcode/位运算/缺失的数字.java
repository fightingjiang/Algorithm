package leetcode.位运算;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:28 2021/7/11
 */
public class 缺失的数字 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= i^nums[i];
        }
        return n;
    }
}
