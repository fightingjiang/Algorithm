package csp34;


public class test {
    public static void main(String[] args) {
        String string = "cba=A+cb";
        System.out.println(string.toUpperCase().replace("+",""));
        System.out.println(string.replaceAll("[^ab]", "P"));
    }
}
