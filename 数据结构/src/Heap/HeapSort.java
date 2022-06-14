package Heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        int[] arr = new int[]{7,1,3,10,5,2,8,9,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 1.把无序数组构建成二叉堆。
        for (int i = (arr.length)/2; i >=0; i--) {
            downAdjust(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 2.循环删除堆顶元素，移到集合尾部，调节堆产生新的堆顶
        for (int i = arr.length-1; i >0 ; i--) {
            // 最后一个元素和第一元素进行交换
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            // 下沉调整最大堆
            downAdjust(arr,0,i);
        }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int tmp =  array[parentIndex];
        //左子节点
        int childIndex = 2*parentIndex+1;
        while (childIndex<length){
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子   最小的孩子节点值
            if(childIndex+1<length&&array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            // 如果父节点小于两个孩子的值，直接跳出
            if(tmp>=array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = tmp;
    }
}
