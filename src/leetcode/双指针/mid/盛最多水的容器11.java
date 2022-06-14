package leetcode.双指针.mid;

public class 盛最多水的容器11 {
    public int maxArea(int[] height) {
        int max = 0,left = 0,right = height.length-1;
        while (left<right){
            if(height[left]>=height[right]){
                max = Math.max((right-left)*height[right],max);
                right--;
            }else {
                max = Math.max((right-left)*height[left],max);
                left++;
            }
        }
        return max;
    }
}
