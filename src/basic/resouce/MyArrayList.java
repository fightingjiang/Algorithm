package basic.resouce;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    //记录数组长度
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initCapacity) {
        if(initCapacity>0){
            elementData = new Object[initCapacity];
        }if(initCapacity==0){
            elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initCapacity);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean add(E e){
        ensureCapacity(size+1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity>elementData.length){
            //扩容
            grow(minCapacity);
        }else {
            return;
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity+oldCapacity>>1;
        //若扩容1.5还小于minCapacity==>newCapacity=minCapacity
        if(newCapacity-minCapacity<0){
            newCapacity=minCapacity;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    public E get(int index){
        rangeCheck(index);
        return elementData(index);
    }

    private E elementData(int index) {
        return (E) elementData[index];
    }

    public E remove(int index){
        rangeCheck(index);
        E oldValue = elementData(index);
        int movedNum = size-index-1;
        //src表示源数组，srcPos表示源数组要复制的起始位置，desc表示目标数组，length表示要复制的长度。
        if(movedNum>0){
            System.arraycopy(elementData,index+1,elementData,index,movedNum);
        }
        elementData[--size] = null;//让GC去回收
        return oldValue;
    }

    private void rangeCheck(int index) {
        if(index>size){
            throw new IndexOutOfBoundsException("超出数组边界: "+index);
        }
    }
}
