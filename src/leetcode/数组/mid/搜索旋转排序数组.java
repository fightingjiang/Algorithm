package leetcode.数组.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:45 2021/7/4
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0){
            return -1;
        }
        if(n==1){
            return nums[0]==target?0:-1;
        }
        int l = 0,r = n-1;
        while (l<=r){
            int mid = (l+r)/2;
            if(target==nums[mid]){
                return mid;
            }
            //左边有序
            if(nums[0]<=nums[mid]){
                //target在0-mid之间
                if(target>=nums[0]&&target<nums[mid]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                //右边有序
                if(nums[mid]<target&&nums[r]>=target){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
