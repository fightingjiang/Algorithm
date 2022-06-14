package leetcode.hashTable.mid;

import java.util.HashMap;

public class 最长重复子数组 {
    public static void main(String[] args) {
        System.out.println(new 最长重复子数组().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
    public int findLength(int[] nums1, int[] nums2) {
        //A: [1,2,3,2,1]
        //B: [3,2,1,4,7]
        //out: 3
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.getOrDefault(nums2[i],0)>0){
                res++;
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        return res;
    }
}
