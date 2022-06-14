package Stack;

import java.util.HashMap;
import java.util.Stack;

class Solution496_f_1 {
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Stack<Integer> stack = new Stack<>();
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       for (int i=0;i<nums2.length;i++){
           while (!stack.isEmpty()&&nums2[i]>stack.peek()){
               hashMap.put(stack.pop(),nums2[i]);
           }
           stack.push(nums2[i]);
       }
       int[] result = new int[nums1.length];

       for (int i=0;i<nums1.length;i++){
           result[i]=hashMap.getOrDefault(nums1[i],-1);
       }


       return result;
   }


}
