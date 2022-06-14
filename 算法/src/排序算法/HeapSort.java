package 排序算法;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {6, 43, 3, 24, 1, 63, 6747, 4, 4, 321, 1, -9, 8};
        headSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //升序   构建最大堆
    public static void headSort(int[] nums){
        //构建堆  从最后一个非叶子节点下沉
        for (int i = nums.length/2-1; i >=0; i--) {
            adjustHead(nums,i,nums.length);
        }
        System.out.println(Arrays.toString(nums));
        //调整堆
        for (int i = nums.length-1; i >0 ; i--) {
            swap(nums,0,i);
            adjustHead(nums,0,i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //升序调整为最大堆   大的元素值上浮
    private static void adjustHead(int[] nums, int i, int length) {
        //下沉元素
        int tmp = nums[i];
        //该节点是否要和叶子节点交换叶子节点
        for (int k = 2*i+1; k < length; k++) {
            //左右叶子节点找最大的
            if(k+1<length&&nums[k+1]>nums[k]){
                k = k+1;
            }
            if(nums[k]>tmp){
                nums[i] = nums[k];
                i = k;
            }else {
                break;
            }
        }
        nums[i] = tmp;
    }
}