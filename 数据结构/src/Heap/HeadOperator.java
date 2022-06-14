package Heap;

import java.util.Arrays;

public class HeadOperator {
    public static void main(String[] args) {
        int[] array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
//        upAdjust(array);
        System.out.println(Arrays.toString(array));
    }

    private static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次下沉调整
        for (int i = (array.length)/2; i >=0 ; i--) {
            downAdjust(array,i,array.length);
        }
    }

    //下浮调整
    private static void downAdjust(int[] array, int parentIndex, int length) {
        int tmp =  array[parentIndex];
        //左子节点
        int childIndex = 2*parentIndex+1;
        while (childIndex<length){
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子   最小的孩子节点值
            if(childIndex+1<length&&array[childIndex+1]<array[childIndex]){
                childIndex++;
            }
          // 如果父节点小于两个孩子的值，直接跳出
            if(tmp<=array[childIndex]){
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = tmp;
    }

    //上浮操作
    public static void upAdjust(int[] array){
        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;
        int tmp = array[childIndex];
        while (childIndex>0&&array[parentIndex]<tmp){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = tmp;
    }
}
