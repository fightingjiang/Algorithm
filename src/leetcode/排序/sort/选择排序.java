package leetcode.排序.sort;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:31 2021/7/20
 */
public class 选择排序 {
    public void selectSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }
}
