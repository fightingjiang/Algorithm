package 字符串;


public class 字符串变形 {
    public static void main(String[] args) {
        System.out.println(trans("This is a sample", 16));
    }
    public static String trans(String s, int n) {
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                sb.append(Character.toUpperCase(c));
            }else if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }else {
                sb.insert(0,c);
                res.insert(0,sb);
                sb = new StringBuilder();
            }
        }
        res.insert(0,sb);
        return res.toString();
    }
}
