import java.util.LinkedList;

public class maxLengthNC41 {
    public int maxLength (int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(list.contains(arr[i])){
                int indexOf = list.indexOf(arr[i]);
                while (indexOf-->=0){
                    list.removeFirst();
                }
            }
            list.add(arr[i]);
            max = Math.max(max,list.size());
        }
        return max;
    }
}
