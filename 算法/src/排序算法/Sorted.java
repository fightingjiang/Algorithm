package 排序算法;

import java.util.Arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 6, 1,1,4,5,21,1,1,1, 7, 3, 9, 0,10};
        QuickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //选择排序
    public static void  SelectSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                    minIndex = nums[minIndex]<nums[j]?minIndex:j;
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }

    //交换排序-冒泡排序 o(n2) o(n2) o(n2) o(1)
    public static void  BubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    //交换排序-快速排序 o(n2) o(n2) o(n2) o(1)
//    public static void QuickSort(int[] nums){
//        QuickSort(nums,0,nums.length-1);
//    }
//    private static void QuickSort(int[] nums, int i, int j) {
//        if(i>=j){
//            return;
//        }
//        int partition = partition(nums,i,j);
//        QuickSort(nums,i,partition-1);
//        QuickSort(nums,partition+1,j);
//    }
//    private static int partition(int[] nums, int i, int j) {
//        int pivot = i;
//        int left = i;
//        int right = j;
//        while (true){
//            while (left<right&&nums[right]>=nums[pivot]){
//                right--;
//            }
//            while (left<right&&nums[left]<=nums[pivot]){
//                left++;
//            }
//            if(left<right){
//                int tmp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = tmp;
//            }else {
//                break;
//            }
//        }
//        int tmp = nums[left];
//        nums[left] = nums[pivot];
//        nums[pivot] = tmp;
//        return left;
//    }
    public static void QuickSort(int[] nums){
        QuickSort(nums,0,nums.length-1);
    }
    private static void QuickSort(int[] nums, int i, int j) {
        if(i>=j) return;
        int partition = partition(nums,i,j);
        QuickSort(nums,i,partition-1);
        QuickSort(nums,partition+1,j);
    }
    private static int partition(int[] nums, int i, int j) {
        int pivot = i;
        int left = i;
        int right = j;
        while (true){
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
        //最后将pivot位置的值与left值交换
        int tmp = nums[pivot];
        nums[pivot] = nums[left];
        nums[left] = tmp;
        return left;
    }


    //希尔排序 插入排序的改进算法 最小增量排序
    public static void ShellSort(int[] nums){
        int dk = nums.length/3+1;
        while (dk>=1){
            ShellSort(nums,dk);
            dk = dk/2;
        }
    }
    private static void ShellSort(int[] nums, int dk) {
        for (int i = dk; i < nums.length; i++) {
            int insertValue = nums[i];
            int index = i-dk;
            while (index>=0&&nums[index]>insertValue){
                nums[index+dk] = nums[index];
                index = index-dk;
            }
            nums[index+dk] = insertValue;
        }
    }


    //归并排序
    public static void mergeSort(int[] nums ){
        mergeSort(nums,0,nums.length-1);
    }
    public static void mergeSort(int[] nums , int left , int right ){
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] newNums = new int[right - left + 1];
        int k = 0;
        int l = left;
        int r = mid+1;
        while (l<=mid&&r<=right){
            if(nums[l]<nums[r]){
                newNums[k++] = nums[l++];
            }else {
                newNums[k++] = nums[r++];
            }
        }
        while (l<=mid){
            newNums[k++] = nums[l++];
        }
        while (r<=right){
            newNums[k++] = nums[r++];
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[left++] = newNums[i];
        }
    }
}
