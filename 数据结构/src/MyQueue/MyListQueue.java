package MyQueue;

import java.util.ArrayList;

public class MyListQueue {
    private int[] values;
    int maxSize;
    int front;
    int rear;

    public MyListQueue(int maxSize) {
        this.maxSize = maxSize;
        values = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void offer(int value){
        if(isFull()){
            throw new RuntimeException("队列已满，无法入队");
        }else {
            rear++;
            values[rear] = value;
        }
    }

    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法出队");
        }
        front++;
        return values[front];
    }

    public void showQueue(){
        for (int i = front+1; i <=rear ; i++) {
            System.out.println(values[i]);
        }
    }

    public static void main(String[] args) {
        MyListQueue queue = new MyListQueue(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println("element:"+queue.poll());
        queue.offer(7);
        queue.showQueue();
        ArrayList<Integer> list = new ArrayList<>();
    }
}
