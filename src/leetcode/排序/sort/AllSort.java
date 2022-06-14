package leetcode.排序.sort;

import java.util.Arrays;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:08 2021/7/9
 */
public class AllSort {

    /**
    * @Author: jiangzhihao
    * @Description:
    * @Data: 2021/7/9 14:10
     *          交换排序
     *              1.冒泡排序 稳定
     *              2.快速排序  不稳定
    */
    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int i, int j) {
        if(i<j){
            int partition = partition(nums,i,j);
            quickSort(nums,i,partition-1);
            quickSort(nums,partition+1,j);
        }
    }

    private int partition(int[] nums, int start, int end) {
        //选基准元素
        int pivot = start;
        int left = start,right = end;
        while (left<right){
            while (left<right&&nums[right]>=nums[pivot]){
                right--;
            }
            while (left<right&&nums[left]<=nums[pivot]){
                left++;
            }
            if(left<right){
                swap(nums,left,right);
            }else {
                break;
            }
        }
        swap(nums,pivot,left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
    * @Author: jiangzhihao
    * @Description:
    * @Data: 2021/7/9 14:57
     *          插入排序
     *              1.普通插入排序
     *              2.希尔排序
    */
    public void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int index = i;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[j]>value){
                    nums[j+1] = nums[j];
                }else {
                    index = j;
                    break;
                }
            }
            nums[index] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 67, 1, 0, 10, -100};
        new AllSort().insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
