package leetcode.排序.mid;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:45 2021/7/10
 */
public class 最小的k个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //优先队列
        PriorityQueue<Integer> heap = new PriorityQueue<>((x1,x2)->(x2-x1));
        for (int i = 0; i < input.length; i++) {
            heap.offer(input[i]);
            if(heap.size()>k){
                heap.poll();
            }
        }
        for (int x:heap) {
            res.add(x);
        }
        return res;
    }

    //快排思想
    public ArrayList<Integer> GetLeastNumbers_Solution_quickSort(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null||k==0) return list;
        randomizedSelected(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void randomizedSelected(int[] input, int l, int r, int k) {
        if(l<r){
            int partition = partition_rand(input,l,r);
            if(partition==k){
                return;
            }else if(partition>k){
                randomizedSelected(input,0,partition-1,k);
            }else {
                randomizedSelected(input,partition+1,r,k);
            }
        }
    }

    private int partition_rand(int[] input, int l, int r) {
        int rand = new Random().nextInt()%(r-l+1);
        swap(input,rand,l);
        return partition(input,l,r);
    }

    private int partition(int[] nums, int start, int end) {
        //选基准元素
        int pivot = start;
        int left = start,right = end;
        while (left<right){
            while (left<right&&nums[right]>=nums[pivot]){
                right--;
            }
            while (left<right&&nums[left]<=nums[pivot]){
                left++;
            }
            if(left<right){
                swap(nums,left,right);
            }else {
                break;
            }
        }
        swap(nums,pivot,left);
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1,x2)->(x2-x1));
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        for (Integer x: queue){
            System.out.println(x);
        }
    }
}
