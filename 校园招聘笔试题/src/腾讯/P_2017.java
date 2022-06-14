package 腾讯;


public class P_2017 {
    public static void main(String[] args) {
        String s = "AkleBiCeilD";
        System.out.println(fun(s));
    }

    public static String fun(String str){
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)){
                str+=" ";
            }
        }
        char[] chars = str.toCharArray();
        int len2 = str.length()-1;
        for (int i = len-1; i >=0; i--) {
            if(Character.isUpperCase(chars[i])){
                chars[len2--] = chars[i];
                chars[i] = ' ';
            }
        }
        return String.valueOf(chars).replace(" ","");
    }
}
