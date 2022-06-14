package leetcode.sort;

public class 第k大的元素 {
    //快速排序  普通解法
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k,0,nums.length-1);
    }

    private int findKthLargest(int[] nums, int k, int i, int j) {
        int partition = partition(nums,i,j);
        if(k<partition+1){
            return findKthLargest(nums,k,i,partition-1);
        }else if(k>partition+1){
            return findKthLargest(nums,k,partition+1,j);
        }else {
            return nums[partition];
        }
    }

    private int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        int left = i,right = j;
        while (left<right){
            while (left<right&&nums[right]<=pivot){
                right--;
            }
            while (left<right&&nums[left]>=pivot){
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
        int[] nums = new int[]{2,5,7,3,1,4,10,11};
        System.out.println(new 第k大的元素().findKthLargest(nums, 5));
    }
}
