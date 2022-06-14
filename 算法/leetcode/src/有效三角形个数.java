import java.util.LinkedList;

public class 有效三角形个数 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4,5,6};
        System.out.println(new 有效三角形个数().triangleNumber(nums));
    }

    int res = 0;
    public int triangleNumber(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(nums,0,track);
        return res;
    }

    private void trackback(int[] nums, int start, LinkedList<Integer> track) {
        if(track.size()==3){
            if(isTriangle(track)){
                res++;
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            trackback(nums,i+1,track);
            track.removeLast();
        }
    }

    private boolean isTriangle(LinkedList<Integer> track) {
        System.out.println(track.toString());
        Integer a = track.get(0);
        Integer b = track.get(1);
        Integer c = track.get(2);
        return (a+b)>c&&a+c>b&&b+c>a;
    }
}
