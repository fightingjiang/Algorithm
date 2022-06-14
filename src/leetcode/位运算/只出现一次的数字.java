package leetcode.位运算;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:15 2021/7/11
 */
public class 只出现一次的数字 {
    //异或操作   ^
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
