package leetcode.二分法;

import static java.util.Arrays.binarySearch;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:37 2021/7/16
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums,target,true);
        int right = binarySearch(nums,target,false)-1;
        if(left<=right&&nums[left]==target&&nums[right]==target){
            return new int[]{left,right};
        }else {
            return new int[]{-1,-1};
        }
    }

    private int binarySearch(int[] nums, int target, boolean flag) {
        int ans = nums.length;
        int l = 0,r = nums.length-1;
        while (l<=r){
            int mid = (l+r)>>1;
            if(nums[mid]>target||(flag&&nums[mid]>=target)){
                r = mid-1;
                ans = mid;
            }else {
                l = mid+1;
            }
        }
        return ans;
    }
}
