public class 寻找第k大的数 {
    public int findKth(int[] a, int n, int K) {
        return find(a,0,n-1,K);
    }

    private int find(int[] a, int left, int right, int k) {
        int partition = partition(a,left,right);
        if(partition+1>k){
            return find(a,left,partition-1,k);
        }else if(partition+1<k){
            return find(a,partition+1,right,k);
        }else {
            return a[partition];
        }
    }

    private int partition(int[] a, int i, int j) {
        int pivot = i;
        int left = i,right = j;
        while (true){
            while (left<right&&a[right]<a[pivot]){
                right--;
            }
            while (left<right&&a[left]>a[pivot]){
                left++;
            }
            if(left<right){
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }else {
                break;
            }
        }
        int tmp = a[pivot];
        a[pivot] = a[left];
        a[left] = tmp;
        return left;
    }
}
