import java.util.*;

public class 出现次数的topK问题 {
    public static void main(String[] args) {
        String[] strings = {"1","1","2","3"};
        String[][] topKstrings = new 出现次数的topK问题().topKstrings(strings, 2);
        for (int i = 0; i < topKstrings.length; i++) {
            System.out.println(String.valueOf(topKstrings[i]));
        }
    }
    public String[][] topKstrings (String[] strings, int k) {
        if(null==strings||strings.length==0) return new String[0][];
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String s:strings
             ) {
            hashmap.put(s,hashmap.getOrDefault(s,0)+1);
        }
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(hashmap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue())==0?o1.getKey().compareTo(o2.getKey()):o2.getValue().compareTo(o1.getValue());
            }
        });
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }

}
