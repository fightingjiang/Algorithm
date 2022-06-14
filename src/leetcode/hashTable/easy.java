package leetcode.hashTable;

import leetcode.链表.ListNode;

import java.util.*;

public class easy {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i+1,map.get(target-nums[i])};
            }
            map.put(nums[i],i+1);
        }
        return new int[]{};
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    //只出现一次的数字
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int res = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            res = iterator.next();
        }
        return res;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode tmp;
        if(l1.val<l2.val){
            tmp = l1;
            tmp.next = mergeTwoLists(l1.next,l2);
        }else {
            tmp = l2;
            tmp.next = mergeTwoLists(l1,l2.next);
        }
        return tmp;
    }

    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(hash[i]!=0){
                return false;
            }
        }
        return true;
    }

    //重复的数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
    public int findRepeatNumber1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if(res[nums[i]]!=0){
                return nums[i];
            }else {
                res[nums[i]]++;
            }
        }
        return -1;
    }

}
