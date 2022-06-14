import java.util.Scanner;


public class csp20131202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int x = 1;
        int sum = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(Character.isDigit(s.charAt(i))){
                int now = s.charAt(i) - '0';
                sum+=(now*x);
                x++;
            }
        }
        char last = (char) ((sum % 11) + '0');
        if((sum % 11)==10){
            last = 'X';
        }
        if((s.charAt(s.length()-1))==last){
            System.out.println("Right");
        }else {
            StringBuffer stringBuffer = new StringBuffer(s);
            stringBuffer.setCharAt(s.length()-1,last);
            System.out.println(stringBuffer.toString());
        }
    }
}
