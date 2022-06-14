package leetcode.hashTable.mid;

import java.util.HashMap;

public class 和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //前缀和
        int[] res = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==k) ans++;
            res[i+1] = res[i]+nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(res[i+1]-res[j]==k) ans++;
            }
        }
        return ans;
    }

    //优化   前缀和+哈希
    public int subarraySum1(int[] nums, int k) {
        //前缀和
        //耗费事件的点 每次到j都需要去枚举从0-j所有可能的和    res[j]-res[i-1]表示i-j的数字之和
        //res[j]-res[i-1]==k符合条件==>res[j]-k==res[i-1]
        //用hashmap记录res[j]之前出现的res[j]-k的值
        int count = 0,pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
