package 动态规划;

public class 子数组最大乘积 {
    public static void main(String[] args) {
        System.out.println(new 子数组最大乘积().maxProduct(new double[]{-0.9,0.4,-5.0,-0.3,-5.0,0.0,1.0,2.2,-2.0}));
    }
    public double maxProduct(double[] arr) {
        int n = arr.length;
        double[] max = new double[n];
        double[] min = new double[n];
        max[0] = arr[0];
        min[0] = arr[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1]*arr[i],Math.max(arr[i],arr[i]*min[i-1]));
            min[i] = Math.min(max[i-1]*arr[i],Math.min(arr[i],arr[i]*min[i-1]));
        }
        double res = arr[0];
        for (int i = 0; i < n; i++) {
            res = Math.max(res,max[i]);
        }
        return res;
    }
}
