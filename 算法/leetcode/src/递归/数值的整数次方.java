package 递归;

public class 数值的整数次方 {
    public static  double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if(n<0){
            return 1/(x*myPow(x,-n-1));
        }else if(n%2==1){
            return x*myPow(x*x,n-1);
        }else {
            return myPow(x*x,n/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 2));
    }

}
