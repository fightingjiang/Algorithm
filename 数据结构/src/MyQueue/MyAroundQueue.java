package MyQueue;

import java.util.regex.Pattern;

public class MyAroundQueue {
    int maxSize;
    int[] arr;
    int front;
    int rear;

    public MyAroundQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        int rear = 0;
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void offer(int value){
        if(isFull()) {
            System.out.println("队列已满，无法在进行入队操作");
            return;
        }else {
            arr[rear] = value;
            rear = (rear+1)%maxSize;
        }
    }

    public int poll(){
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }else {
            int num = arr[front];
            front = (front+1)%maxSize;
            return num;
        }
    }

    public void showQueue(){
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");
        }
        int start = front;
        while (start!=rear){
            System.out.println(arr[start]);
            start = (start+1)%maxSize;
        }
    }
}
