package leetcode.双指针.mid;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int left = 0,right = nums.length-1;
        for (int i = 0; i <= right; i++) {
            //nums[i]可能连续为2
            while (i <= right&&nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            }
           if(nums[i]==0){
               int tmp = nums[i];
               nums[i] = nums[left];
               nums[left] = tmp;
                left++;
            }
        }
    }
}
