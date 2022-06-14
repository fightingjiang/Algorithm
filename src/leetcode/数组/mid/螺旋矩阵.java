package leetcode.数组.mid;

import java.util.ArrayList;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 16:21 2021/7/4
 */
public class 螺旋矩阵 {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0){
            return list;
        }
        int up = 0,down = matrix.length-1,left = 0,right = matrix[0].length-1;
        while (true){
            if(left>right){
                return list;
            }else {
                for (int i = left; i <=right ; i++) {
                    list.add(matrix[up][i]);
                }
                up++;
            }
            if(up>down){
                return list;
            }else {
                for (int i = up ; i <= down; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }
            if(left>right){
                return list;
            }else {
                for (int i = right; i >=left ; i--) {
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if(up>down){
                return list;
            }else {
                for (int i = down; i >=up ; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
    }
}