package 排序算法;

import java.util.Arrays;

public class Sorts {
    public static void main(String[] args) {
        int[] nums = {1, 3,2,6,5,7,8,9,10};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    //快速排序
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private static void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int partition = partition(nums,i,j);
        quickSort(nums,i,partition-1);
        quickSort(nums,partition+1,j);
    }

    private static int partition(int[] nums, int i, int j) {
        int pivot = i;
        int left = i;
        int right = j;
        while (true){
            //从右往左找一个小于nums[pivot]
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
        int tmp = nums[left];
        nums[left] = nums[pivot];
        nums[pivot] = tmp;
        return left;
    }

    //希尔排序
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
    private static void mergeSort(int[] nums, int left, int right) {
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
        int k =0;
        int l = left;
        int r = mid+1;
        while (l<=mid&&r<=right){
            if(nums[l]<=nums[r]){
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
        //最后把newNums赋值给nums
        for ( k = 0; k < newNums.length; k++) {
            nums[left++] = newNums[k];
        }
    }

    //堆排序
    public static void heapSort(int[] nums){
        //构建大顶堆  从第一个非叶子节点开始  o(n)
        for (int i = nums.length/2-1; i >=0 ; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums,i,nums.length);
        }
        System.out.println(Arrays.toString(nums));
        //  n*log(n);1`
        for (int i = nums.length-1; i >0 ; i--) {
            //将堆顶和堆尾未交换元素元素交换
            swap(nums,0,i);
            //调整堆   从根节点往下循环找  O(log n)
            adjustHeap(nums,0,i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void adjustHeap(int[] nums,int i,int length){
        int tmp = nums[i];//先取出当前元素
        for (int k = 2*i+1; k < length ; k = k*2+1) {
            if(k+1<length&&nums[k]<nums[k+1]){
                k++;
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
