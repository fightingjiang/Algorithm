package Stack;

import java.util.HashMap;
import java.util.Stack;

 class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int n:nums2){
            if(!stack.isEmpty()&&stack.peek()<n){
                hashMap.put(stack.pop(),n);
            }
            stack.push(n);
        }
        int i =0;
        for (int n:nums1){
            if (hashMap.containsKey(n)){
                result[i++]=hashMap.get(n);
            }else{
                result[i++]=-1;
            }
        }
        return result;


    }


}
