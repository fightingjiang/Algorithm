import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class csp20190302 {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('+',1);
        hashMap.put('-',1);
        hashMap.put('x',2);
        hashMap.put('/',2);
        Stack<Integer> values = new Stack<>();
        Stack<Character> opts = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            while (!values.isEmpty()){
                values.pop();
            }
            while (!opts.isEmpty()){
                opts.pop();
            }
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if(Character.isDigit(ch)){
                    values.push(ch-'0');
                }else {
                    if(opts.isEmpty()){
                        opts.push(ch);
                    }else {
                        while (!opts.isEmpty()) {
                            if (hashMap.get(ch) > hashMap.get(opts.peek())) {
                                break;
                            } else {
                                    Character opt = opts.pop();
                                    Integer second = values.pop();
                                    Integer first = values.pop();
                                    values.push(fun(first, second, opt));
                            }
                        }
                        opts.push(ch);
                    }
                }
            }
            while (!opts.isEmpty()){
                Character opt = opts.pop();
                Integer second = values.pop();
                Integer first = values.pop();
                values.push(fun(first,second,opt));
            }
            if(values.pop()==24){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }

    private static Integer fun(Integer first, Integer second, Character opt) {
        switch (opt){
            case '+':{
                return first+second;
            }
            case '-':{
                return first-second;
            }
            case 'x':{
                return first*second;
            }
            case '/':{
                return first/second;
            }
        }
        return null;
    }
}
/*
2
1x9-5/9
6x7-3x6
 */