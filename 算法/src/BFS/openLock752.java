package BFS;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class openLock752 {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < deadends.length; i++) {
            dead.add(deadends[i]);
        }
        visited.add("0000");
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(dead.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return step;
                }
                //枚举8中情况
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur,j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                }
                for (int j = 0; j < 4; j++) {
                    String down = minusOne(cur,j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if(chars[j]=='9'){
            chars[j] = '0';
        }else {
            chars[j]+=1;
        }
        return new String(chars);
    }

    private String minusOne(String cur, int j) {
        char[] chars = cur.toCharArray();
        if(chars[j]=='0'){
            chars[j] = '9';
        }else {
            chars[j]-=1;
        }
        return new String(chars);
    }
}
