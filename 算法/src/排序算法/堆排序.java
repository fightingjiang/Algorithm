package 排序算法;

import java.util.Arrays;

public class 堆排序 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,6,5,7,8,9,10};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //升序
    static public void heapSort(int[] nums){
        //构建大顶堆  初始堆  O(n)
        for (int i = nums.length/2-1; i >=0 ; i--) {
            adjustHeap(nums,i,nums.length);
        }
        System.out.println(Arrays.toString(nums));
        //调整堆
        for (int i = nums.length-1; i >=1 ; i--) {
            swap(nums,0,i);
            adjustHeap(nums,0,i-1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //O(logn)
    static private void adjustHeap(int[] nums, int index, int len) {
        //下沉的值
        int value = nums[index];
        for (int i = index*2+1; i < len; i = i*2+1) {
            if(i+1<len&&nums[i+1]>nums[i]){
                i = i+1;
            }
            if(nums[i]>value){
                nums[index] = nums[i];
                index = i;
            }else {
                break;
            }
        }
        nums[index] = value;
    }
}
