package 笔试.华为;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 字母表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String key = sc.nextLine();
            String s = sc.nextLine();
            char[] miyao = new char[26];
            int k = 0;
            HashSet<Character> set = new HashSet<>();
            StringBuilder miwen = new StringBuilder();
            int[] chars = new int[26];
            Arrays.fill(chars,1);
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if(!set.contains(c)){
                    miyao[k++] = c;
                    set.add(c);
                    chars[c-'a']--;
                }
            }
            for (int i = 0; i < 26 ; i++) {
                if(chars[i]!=0){
                    miyao[k++] = (char) ((char) i+'a');
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                miwen.append(miyao[c-'a']);
            }
            System.out.println(miwen.toString());
        }
    }
}
