package leetcode.排序.sort;

import java.util.Arrays;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:02 2021/7/20
 */
public class 选择_手撕堆排序 {
    public void heapSort(int[] nums) {
        int len = nums.length;
        //1.构建大根堆
        // 从最后一个非叶子节点开始，依次下沉调整
        for (int i = (len-2)/2; i >=0 ; i--) {
            buildMaxHeap(nums,i,nums.length);
        }
        System.out.println(Arrays.toString(nums));
        // 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶。
        // 集合升序  意味着要把大顶堆对顶元素依次发到最底
        for (int i = nums.length - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            buildMaxHeap(nums,0,i);
        }
    }

    //父节点下沉
    private void buildMaxHeap(int[] nums, int parentIndex,int len) {
        int tmp = nums[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex<len){
            //孩子找最小值
            if(childIndex+1<len&&nums[childIndex+1]>nums[childIndex]){
                childIndex++;
            }
            //如果父节点比孩子节点都小，则无需下沉
            if(tmp>=nums[childIndex]){
                break;
            }
            nums[parentIndex] = nums[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        nums[parentIndex] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        new 选择_手撕堆排序().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
