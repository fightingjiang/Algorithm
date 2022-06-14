package leetcode.hashTable.mid;


import java.util.*;

public class 前k个高频单词 {
    static public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()==o2.getValue()){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
//        String[] str = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent(str, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
