public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(jumpFloor01(5));
    }

    static public int jumpFloor(int target) {
        if(target<=0) return 0;
        if(target==1) return 1;
        if(target==2) return 2;
        return jumpFloor(target-1)+jumpFloor(target-2);
    }
    static public int jumpFloor01(int target) {
        if(target==0) return 1;
        if(target==1) return 1;
        int f1 = 1;
        int f2 = 1;
        int sum = 0;
        for (int i = 2; i <= target; i++) {
            sum = f1+f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}
