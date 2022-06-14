public class Topk {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 6, 7, 8, 9};
        System.out.println(new Topk().findKth(nums, nums.length, 4));
    }

    public int findKth(int[] a, int n, int K) {
        return find(a,0,n-1,K);
    }

    private int find(int[] a, int low, int high, int K) {
        int partition = partition(a,low,high);
        if(partition+1>K){
            return find(a,low,partition-1,K);
        }else if(partition+1<K){
            return find(a,partition+1,high,K);
        }else {
            return a[partition];
        }
    }

    private int partition(int[] a, int i,int j) {
        int pivot = i;
        int left = i;
        int right = j;
        while (true){
            while (left<right&&a[right]<=a[pivot]){
                right--;
            }
            while (left<right&&a[left]>=a[pivot]){
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
