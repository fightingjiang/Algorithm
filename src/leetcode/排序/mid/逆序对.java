package leetcode.排序.mid;

import leetcode.排序.sort.归并排序;

import java.util.Arrays;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:24 2021/7/9
 */
public class 逆序对 {
    int count = 0;
    public int mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
    }

    private void merge(int[] nums, int l, int mid,  int r) {
        int l1 = l,r1 = mid,l2 = mid+1,r2 = r;
        int[] tmp = new int[r - l + 1];
        int cnt = 0;
        while (l1<=r1&&l2<=r2){
            if(nums[l1]<=nums[l2]){
                tmp[cnt++] = nums[l1++];
            }else {
                tmp[cnt++] = nums[l2++];
                count+=(r1-l1+1);
            }
        }
        while (l1<=r1){
            tmp[cnt++] = nums[l1++];
        }
        while (l2<=r2){
            tmp[cnt++] = nums[l2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[l+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,3,2,3,1};
        System.out.println(new 逆序对().mergeSort(nums));
        System.out.println(Arrays.toString(nums));
    }
}
