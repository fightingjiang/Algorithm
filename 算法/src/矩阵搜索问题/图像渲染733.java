package 矩阵搜索问题;

public class 图像渲染733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        fill(image,sr,sc,originColor,newColor);
        return image;
    }

    //回溯算法
    private void fill(int[][] image, int sr, int sc, int originColor, int newColor) {
        //超出数组范围
        if(!inImage(image,sr,sc)) return;
        //碰壁：遇到非originColor颜色元素
        if(image[sr][sc]!=originColor) return;
        //表示访问过
        image[sr][sc] = -1;
        fill(image,sr+1,sc,originColor,newColor);
        fill(image,sr-1,sc,originColor,newColor);
        fill(image,sr,sc+1,originColor,newColor);
        fill(image,sr,sc-1,originColor,newColor);
        image[sr][sc] = newColor;
    }

    private boolean inImage(int[][] image, int sr, int sc) {
        return sr>=0&&sr<image.length&&sc>=0&&sc<image[0].length;
    }
}
