import java.math.BigDecimal;

public class BigNumberAdd {
    public static void main(String[] args) {
        System.out.println("733064366".length());
        System.out.println(solve("733064366", "459309139"));
    }

    static public String solve (String s, String t) {
        StringBuilder result = new StringBuilder();
        int tmp = 0,ls = s.length()-1,lt = t.length()-1;
        System.out.println(ls);
        while (ls>=0||lt>=0||tmp==1){
            int l = ls>=0?(s.charAt(ls--))-'0':0;
            int r = lt>=0?(t.charAt(lt--))-'0':0;
            int plus = l+r+tmp;
            tmp = plus/10;
            char ch = (char)(plus%10+'0');
            result.append(ch);
        }
        return result.reverse().toString();
    }
}
