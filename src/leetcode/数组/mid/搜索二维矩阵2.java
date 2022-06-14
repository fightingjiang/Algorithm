package leetcode.数组.mid;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 17:48 2021/7/23
 */
public class 搜索二维矩阵2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int clown = 0;
        while (row>=0&&clown<matrix[0].length){
            if(matrix[row][clown]>target){
                row--;
            }else if(matrix[row][clown]<target){
                clown++;
            }else {
                return true;
            }
        }
        return false;
    }
}
