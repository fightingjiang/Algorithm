package leetcode.排序.sort;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:43 2021/7/20
 */
public class 插入排序 {
    public void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i-1;
            while (index>=0&&arr[index]>value){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 8, 1, 2};
        new 插入排序().insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
