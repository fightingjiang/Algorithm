package find;

public class BinaryFind extends Find{
    @Override
    public int contains(int[]n,int num) {
        int len = n.length;
        int lo = 0;
        int hi = len-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(n[mid]>num){
                hi = mid-1;
            }else if(n[mid]<num){
                lo =mid +1;
            }else{
                return mid;
            }
        }
        return  lo;
    }
}
