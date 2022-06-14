package leetcode.sort;

public class 快速排序 {
    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int i, int j) {
        if(i>=j) return;
        int partition = partition(nums,i,j);
        quickSort(nums,i,partition-1);
        quickSort(nums,partition+1,j);
    }

    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        int left = i,right = j;
        while (left<right){
            while (left<right&&nums[right]>=pivot){
                right--;
            }
            while (left<right&&nums[left]<=pivot){
                left++;
            }
            if(left<right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[left];
        nums[left] = tmp;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 2, 4, 6, 1, 9, 0};
        new 快速排序().quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
