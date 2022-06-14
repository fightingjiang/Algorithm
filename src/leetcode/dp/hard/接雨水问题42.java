package leetcode.dp.hard;

public class 接雨水问题42 {
    //双指针
    public static int trap(int[] height) {
        int n = height.length;
        int i = 0,j=n-1;
        int ans = 0;
        int min = 0;
        while (i<j){
            if(i<j&&height[i]<=height[j]){
                min = height[i];
                while (i<j&&height[i]<=height[j]){
                    i++;
                    if(height[i]>min){
                        min = height[i];
                    }
                    ans+=min-height[i];
                    System.out.println(ans);
                }
            }
            if(i<j&&height[i]>height[j]){
                min = height[j];
                while (i<j&&height[i]>height[j]){
                    j--;
                    if(height[j]>min){
                        min = height[j];
                    }
                    ans+=min-height[j];
                    System.out.println(ans);
                }
            }
        }
        return ans;
    }

    //双指针优化   lmax,rmax
    public static int trap1(int[] height) {
        if(height.length==0||height==null) return 0;
        int n = height.length;
        int i = 0,j = n-1;
        int ans = 0;
        int lmax = height[i],rmax = height[j];
        while (i<=j){
            if(height[i]<=height[j]){
                lmax = Math.max(lmax,height[i]);
                ans+=lmax-height[i];
                i++;
            }else {
                rmax = Math.max(rmax,height[j]);
                ans+=rmax-height[j];
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
