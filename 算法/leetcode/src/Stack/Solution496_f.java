package Stack;

import java.util.HashMap;
import java.util.Stack;

class Solution496_f {
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Stack<Integer> stack = new Stack<>();
       HashMap<Integer, Integer> hashMap = new HashMap<>();

       for (int i=nums2.length-1;i>=0;i--){
           while (!stack.isEmpty()&&stack.peek()<nums2[i]){
               stack.pop();
           }
           hashMap.put(nums2[i],stack.isEmpty()?-1:stack.peek());
           stack.push(nums2[i]);
       }

       int[] result = new int[nums1.length];
       for (int i=0;i<nums1.length;i++){
           result[i]=hashMap.getOrDefault(nums1[i],-1);
       }


       return result;
   }


}
