package leetcode.自动机;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 21:54 2021/7/23
 */
public class 字符串转换整数 {
    public int myAtoi(String str) {
        int state = 0;
        long num = 0;
        int sign = 1;
        for (int i = 0; i < str.length()&&state!=3; i++) {
            char c = str.charAt(i);
            switch (state){
                case 0:
                    if(c==' ') continue;
                    else if(c=='+'||c=='-'){
                        if(c=='-') sign = -1;
                        state = 1;
                    }else if(Character.isDigit(c)){
                        num = num*10+c-'0';
                        state = 2;
                    }else {
                        state = 3;
                    }
                    break;
                case 1:
                    if(Character.isDigit(c)){
                        num = num*10+c-'0';
                        num = sign==1?Math.min(num,(long)Integer.MAX_VALUE):Math.min(num,-(long)Integer.MIN_VALUE);
                        state = 2;
                    }else {
                        state = 3;
                    }
                    break;
                case 2:
                    if(Character.isDigit(c)){
                        num = num*10+c-'0';
                        num = sign==1?Math.min(num,(long)Integer.MAX_VALUE):Math.min(num,-(long)Integer.MIN_VALUE);
                        state = 2;
                    }else {
                        state = 3;
                    }
                    break;
            }
        }
        return (int) num*sign;
    }
}
