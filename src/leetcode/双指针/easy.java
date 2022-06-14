package leetcode.双指针;

public class easy {
    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1,i = m-1,j = n-1;
        while (i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
        if(j>=0){
            for (int l = j; l >= 0; l--) {
                nums1[k--] = nums2[l];
            }
        }
    }

    // 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < n; fast++) {
            if(nums[fast]!=nums[fast-1]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    //有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int m = nums.length-1;
        int left = 0,right = nums.length-1;
        while (left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                ans[m--] = nums[left]*nums[left];
                left++;
            }else {
                ans[m--] = nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }

    //实现 strStr() 函数。
    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0) return 0;
        int length = needle.length();
        int index1 = 0,index2 = 0;
       while (index1<haystack.length()){
            if(haystack.charAt(index1)==needle.charAt(index2)){
                index2++;
                if(index2==length){
                    return index1-length+1;
                }
            }else {
                index2 = 0;
            }
            index1++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
