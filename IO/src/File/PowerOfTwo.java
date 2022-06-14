package File;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(888));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n+1;
    }
}
