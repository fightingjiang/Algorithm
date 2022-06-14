package leetcode.二分法;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:29 2021/7/16
 */
public class 旋转数组中的最小元素 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0,r = nums.length-1;
        while (l<=r){
            int mid = (l+r)>>1;
            //左边有序
            if(nums[l]<nums[mid]){
                min = Math.min(min,nums[l]);
                l = mid+1;
            }else {
                min = Math.min(min,nums[mid]);
                r = mid-1;
            }
        }
        return min;
    }
}
