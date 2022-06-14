package leetcode.排序.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 15:17 2021/7/9
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0],right = intervals[i][1];
            if(list.size()==0||list.get(list.size()-1)[1]<left){
                list.add(new int[]{left,right});
            }else {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] merge = new 合并区间().merge(new int[][]{{1, 4}, {0, 4}});
        System.out.println();
    }
}
