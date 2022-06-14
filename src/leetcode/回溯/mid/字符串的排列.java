package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:46 2021/7/16
 */
public class 字符串的排列 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        StringBuilder track = new StringBuilder();
        boolean[] visited = new boolean[str.length()];
        dfs(charArray,track,visited);
        Collections.sort(res);
        return res;
    }

    private void dfs(char[] charArray, StringBuilder track, boolean[] visited) {
        if(track.length()==charArray.length){
            res.add(track.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if(visited[i]==true||(i>0&&(charArray[i-1]==charArray[i]&&visited[i-1]==true))){
                continue;
            }
            track.append(charArray[i]);
            visited[i] = true;
            dfs(charArray,track,visited);
            track.deleteCharAt(track.length()-1);
            visited[i] = false;
        }
    }
}
