import java.util.HashMap;

public class 两数之和NC61 {
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(hashMap.containsKey(target-numbers[i])){
                return new int[]{hashMap.get(target-numbers[i]),i+1};
            }else {
                hashMap.put(numbers[i],i+1);
            }
        }
        return new int[0];
    }
}
