import com.sun.xml.internal.bind.v2.model.core.ID;

public class 转动过的数组寻找目标值 {
    public int search (int[] A, int target) {
        int left = 0,right = A.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(A[mid]==target) return mid;
            //左侧有序
            if(A[mid]>=A[left]){
                //左侧有序且target在其中
                if(target<A[mid]&&A[left]<=target)
                    right = mid-1;
                else left = mid+1;
            }else {
                //右侧有序 且target在其中
                if(A[mid]<target&&target<=A[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
