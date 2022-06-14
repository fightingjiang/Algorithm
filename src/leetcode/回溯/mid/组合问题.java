package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 11:23 2021/6/22
 */
public class 组合问题 {
    /**
     * @Author: jiangzhihao
     * @Description:
     *      组合   给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * @Data: 2021/6/22 11:12
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> track = new ArrayList<>();
        trackback(track,n,k,1);
        return res;
    }

    private void trackback(ArrayList<Integer> track, int n, int k, int start) {
        //满足条件
        if(track.size()==k){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            trackback(track,n,k,i+1);
            track.remove(track.size()-1);
        }
    }

}
