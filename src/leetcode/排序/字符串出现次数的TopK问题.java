package leetcode.排序;

import java.util.*;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:21 2021/7/16
 */
public class 字符串出现次数的TopK问题 {
    public String[][] topKstrings (String[] strings, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String str:strings){
            hashMap.put(str,hashMap.getOrDefault(str,0)+1);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue()==o1.getValue()?o1.getKey().compareTo(o2.getKey()):o2.getValue()-o1.getValue());
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }
}
