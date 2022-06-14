package leetcode.位运算;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 13:22 2021/7/11
 */
public class 为1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n!=0){
            n = n&(n-1);
            res++;
        }
        return res;
    }
}
