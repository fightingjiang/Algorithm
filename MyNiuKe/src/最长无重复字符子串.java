import java.util.HashMap;

public class 最长无重复字符子串 {
    public int maxLength (int[] arr) {
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
