package leetcode.排序.sort;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:49 2021/7/20
 */
public class 插入_希尔排序 {
    public void shellSort(int[] nums){
        int k = nums.length/2;
        while (k>0){
            shellSort(nums,k);
        }
    }

    public void shellSort(int[] nums,int k){
        for (int i = k; i < nums.length; i++) {

        }
    }

    public static void main(String[] args) {
        System.out.println(2/2);
    }
}
