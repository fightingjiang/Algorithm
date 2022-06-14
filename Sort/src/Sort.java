import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
//        int[] nums = {3, 6, 2, 6, 1,1,4,5,21,1,1,1, 7, 3, 9, 0,10};
        int[] nums = {1, 6, 3, 26, 7, 3, 1, 9};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
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
    public static void QuickSort(int[] nums){
        QuickSort(0,nums.length-1,nums);
    }
    private static void QuickSort(int i, int j, int[] nums) {
        if(i>=j) {
            return;
        }
        int partition = partition(i,j,nums);
        QuickSort(i,partition-1,nums);
        QuickSort(partition+1,j,nums);
    }

    //快速排序-partition函数
    private static int partition(int i, int j, int[] nums) {
        int pivot = i;
        int left = i;
        int right = j;
        while (true){
            //先左移
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

    public int findKth(int[] a, int n, int K) {
        return find(a, 0, n-1, K);
    }

    //递归寻找数组中第K大的元素
    private int find(int[] a, int low, int high, int K) {
        int pivot = partition( low, high,a);

        if(pivot + 1 < K)//中轴位置少于K个，在右子数组中继续查找
            return find(a, pivot+1, high, K);
        else if(pivot + 1 > K)//中轴位置大于K个，在左子数组中继续查找
            return find(a, low, pivot-1, K);
        else//中轴元素正好是第K大的元素
            return a[pivot];
    }

    //插入排序
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int insertValue = nums[i];
            int index = i-1;
            while (index>=0&&nums[index]>insertValue){
                nums[index+1] = nums[index];
                index--;
            }
            nums[index+1] = insertValue;
        }
    }

    //希尔排序 插入排序的改进算法 最小增量排序
    public static void ShellSort(int[] nums){
        int dk = nums.length/3+1;
        while (dk>=1){
            ShellSort(nums,dk);
            dk = dk/2;
        }
    }
    //插入排序中的  1改成dk
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
        for (k = 0; k < newNums.length ; k++) {
            nums[left++] = newNums[k];
        }
    }

    //计数排序
    public static void countSort(int[] nums){
        int max = Integer.MIN_VALUE;
        //找最大元素确定统计数组的长度
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i],max);
        }
        int[] countArray = new int[max+1];
        //遍历数组，填充统计数组
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        //遍历统计数组输出结果
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                nums[index++] = i;
            }
        }
    }


    //桶排序
    public static void bucketSort(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        int bucketNum = (max-min)/nums.length+1;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }
        //将每个元素装入桶
        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i]-min)/nums.length;
            bucket.get(num).add(nums[i]);
        }
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }
        for (int i = 0; i < bucketNum; i++) {
            
        }
    }
}
