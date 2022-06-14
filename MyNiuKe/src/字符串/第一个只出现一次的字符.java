package 字符串;

public class 第一个只出现一次的字符 {
    //"google" 返回下标4
    public int FirstNotRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(str.indexOf(c)==str.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }
}
