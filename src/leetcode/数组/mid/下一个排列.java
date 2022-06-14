package leetcode.数组.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:43 2021/7/24
 */
public class 下一个排列 {
    public void nextPermutation(int[] nums) {
        //两次扫描
        int i = nums.length-2;
        //i:要找一个当前元素比后一个元素小的，j:在后面的递减元素中找第一个比当前元素大的
        //交换i,j 然后把i+1开始的元素反转
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        //i找到了一个小的值
        if(i>=0){
            int j = nums.length-1;
            //找到和i交换的值   比nums[i]大就行
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            //交换nums[i] 和 nums[j]
            swap(nums,i,j);
        }
        //若本来就是最大的则全部反转  否则只反转i+1之后的  因为i+1之后的是一个递减的序列
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length-1;
        while (i<j){
            swap(nums,i,j);;
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
