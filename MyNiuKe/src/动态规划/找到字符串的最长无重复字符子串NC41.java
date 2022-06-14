package 动态规划;

import java.util.HashMap;
import java.util.LinkedList;

public class 找到字符串的最长无重复字符子串NC41 {
    public int maxLength (int[] arr) {
        //滑动窗口算法
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 0;
        int l = -1;
        for (int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i])){
                l = Math.max(l,hashMap.get(arr[i]));
            }
            hashMap.put(arr[i],i);
            max = Math.max(max,i-l);
        }
        return max;
    }
}
