package 数组;

public class 数在升序数组中出现的次数 {
    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{1, 2,2, 3, 3, 3, 3, 4, 5}, 3));
    }
    static public int GetNumberOfK(int [] array , int k) {
        //[1,2,3,3,3,3,4,5],3
        int res = find(array,k,0,array.length);
        return res;
    }

    static private int find(int[] array, int k,int l,int r) {
        if(l>=r) {
            if(array[l]==k) return 1;
            else return 0;
        }
        int mid = l+(r-l)/2;
        if(k>array[mid]){
            return find(array,k,mid+1,r);
        }else  if(k==array[mid]){
            return find(array,k,l,mid-1)+find(array,k,mid+1,r)+1;
        }else {
            return find(array,k,l,mid-1);
        }
    }
}
