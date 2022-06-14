package leetcode.回溯.mid;

import java.util.ArrayList;
import java.util.List;


/**
* @Author: jiangzhihao
* @Description:
 *          回溯算法模板
 *              trackback(){
 *                  if(满足条件){
 *                      res.add(new arraylist(track))
 *                      return;
 *                  }
 *                  //有点像深度优先搜索
 *                  做循环for(int i = start;i<;i++){
 *                      做选择  track.add(nums[i])
 *                      trackback(...,i)
 *                      撤销选择
 *                  }
 *              }
 *
* @Data: 2021/6/22 10:54
*/
public class 子集问题 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = new 子集问题().subsets(nums);
        for (int i = 0; i < subsets.size(); i++) {
            System.out.println(subsets.get(i).toString());
        }
    }

    /**
    * @Author: jiangzhihao
    * @Description:
     *       //子集问题
     *      // 输入：nums = [1,2,3]
     *     // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    * @Data: 2021/6/22 10:55
    */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //track记录路径
        ArrayList<Integer> track = new ArrayList<>();
        trackback(nums,track,0);
        return res;
    }

    private void trackback(int[] nums, ArrayList<Integer> track, int start) {
        if(start>nums.length) return;
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            //做选择
            track.add(nums[i]);
            //回溯 往下一个节点
            trackback(nums,track,i+1);
            //撤销选择
            track.remove(track.size()-1);
        }
    }

}
