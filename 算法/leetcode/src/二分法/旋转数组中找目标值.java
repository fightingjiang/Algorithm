package 二分法;

public class 旋转数组中找目标值 {
    public int search (int[] nums, int target) {
        int low = 0,high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            //如果左边有序
            if(nums[mid]>nums[low]){
                if(nums[mid]>target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else {
                //右边有序
                if(target>nums[mid]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
