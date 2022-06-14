package leetcode.回溯.mid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:14 2021/6/26
 */
public class 括号问题 {
    ArrayList<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        backtrack(track,0,0,n);
        return res;
    }

    private void backtrack(StringBuilder track, int open, int close, int max) {
        if(track.length()==max*2){
            res.add(new String(track));
            return;
        }
        if(open<max){
            track.append('(');
            backtrack(track,open+1,close,max);
            track.deleteCharAt(track.length()-1);
        }
        if(close<open){
            track.append(')');
            backtrack(track,open,close+1,max);
            track.deleteCharAt(track.length()-1);
        }
    }
}
