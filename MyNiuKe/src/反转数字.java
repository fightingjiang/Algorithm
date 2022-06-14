public class 反转数字 {
    public int reverse (int x) {
        boolean flag = x<0?true:false;
        if(flag) x = -x;
        Integer res = Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
        return flag?-res:res;
    }
}
