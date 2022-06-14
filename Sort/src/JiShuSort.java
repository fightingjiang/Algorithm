public class JiShuSort {
    public static void main(String[] args) {
        int[] arr = {43, 9, 289, 89, 189};
        jishuSort(arr);
        for(int a : arr) {
            System.out.println(a);
        }
    }

    private static void jishuSort(int[] arr) {
        int maxSize = arr.length;
        int[][] bucket = new int[10][maxSize];
        //记录每个桶存的元素
        int[] elementCounts = new int[10];
        //获取该数组中最大元素的位数
        int maxDigits =  getMaxDigits(arr);
//        System.out.println(maxDigits);
        for (int i = 1,step = 1; i <= maxDigits; i++,step*=10) {
            for (int j = 0; j < arr.length; j++) {
                //取出所需的位数
                int digits = arr[j]/step%10;
                bucket[digits][elementCounts[digits]++] = arr[j];
            }

            int index = 0;
            for (int j = 0; j < 10; j++) {
                int position = 0;
                while (elementCounts[j]>0){
                    arr[index] = bucket[j][position];
                    position++;
                    elementCounts[j]--;
                    index++;
                }
            }
        }
    }

    private static int getMaxDigits(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        String len = max+"";
        return len.length();
    }
}
