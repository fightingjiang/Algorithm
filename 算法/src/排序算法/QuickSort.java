package 排序算法;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 26, 7, 3, 1, 9};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if(l>=r) return;
        int partition = partition(nums,l,r);
        quickSort(nums,l,partition-1);
        quickSort(nums,partition+1,r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = l,left = l,right = r;
        while (true){
            //从右往左找个比基准元素小的
            while (left<right&&nums[right]>=nums[pivot]){
                right--;
            }
            while (left<right&&nums[left]<=nums[pivot]){
                left++;
            }
            if(left<right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }else {
                break;
            }
        }
        int tmp = nums[pivot];
        nums[pivot] = nums[left];
        nums[left] = tmp;
        return left;
    }
}
