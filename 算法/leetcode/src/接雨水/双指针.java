package 接雨水;

public class 双指针 {
    public int trap(int[] height) {
        if(height.length==0||height==null) return 0;
        int n = height.length;
        int res = 0;
        int lmax = height[0],rmax = height[n-1];
        int left = 0,right = n-1;
        while (left<=right){
            if(lmax<rmax){
                lmax = Math.max(lmax,height[left]);
                res+=lmax-height[left];
                left++;
            }else {
                rmax = Math.max(rmax,height[right]);
                res+=rmax-height[right];
                right--;
            }
        }
        return res;
    }
}
