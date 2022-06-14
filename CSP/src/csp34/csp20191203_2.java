package csp34;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class csp20191203_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String str1 = scanner.nextLine();
            String str = str1.toUpperCase().replace("+", "");
            String[] split = str.split("=");
            HashMap<Character, Integer> hash1 = new HashMap<>();
            HashMap<Character, Integer> hash2 = new HashMap<>();
            for (int j = 0; j < split[0].length(); j++) {
                if(!hash1.containsKey(split[0].charAt(j))){
                    hash1.put(split[0].charAt(j),1);
                }else {
                    int integer = hash1.get(split[0].charAt(j));
                    integer++;
                    hash1.put(split[0].charAt(j),integer);
                }
            }
            for (int j = 0; j < split[1].length(); j++) {
                if(!hash2.containsKey(split[1].charAt(j))){
                    hash2.put(split[1].charAt(j),1);
                }else {
                    Integer integer = hash2.get(split[1].charAt(j));
                    integer++;
                    hash2.put(split[1].charAt(j),integer);
                }
            }
            Set<Map.Entry<Character, Integer>> entries = hash1.entrySet();
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry:entries
                 ) {
                if (hash2.get(entry.getKey())!=entry.getValue()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Y");
            }else {
                System.out.println("N");
            }
        }
    }
}
