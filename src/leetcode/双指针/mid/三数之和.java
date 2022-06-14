package leetcode.双指针.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<3) return res;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[len-1]+nums[len-2]<0){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]>0){
                break;
            }
            int left = i+1,right = len-1;
            while (left<right){
                if(nums[left]+nums[right]+nums[i]==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    right--;
                }else if(nums[left]+nums[right]+nums[i]<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }


    //两数之和
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left<right){
            if(numbers[left]+numbers[right]>target){
                right--;
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{};
    }

}
