package 数组;

public class 奇数位于偶数之前 {

    public int[] reOrderArray (int[] array) {
        //并保证奇数和奇数，偶数和偶数之间的相对位置不变。
        int[] res = new int[array.length];
        int l = 0;
        int r = array.length-1;
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                res[l++] = array[i];
            }
        }
        for (int i = array.length-1; i >=0 ; i--) {
            if(array[i]%2==0){
                res[r--] = array[i];
            }
        }
        return res;
    }
}
