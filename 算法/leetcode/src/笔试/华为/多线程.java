package 笔试.华为;


import java.util.ArrayList;
import java.util.Scanner;

public class 多线程 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            MyThread myThread = new MyThread(n,1);
            Thread t1 = new Thread(() -> {
                myThread.print(1, 2, 'A');
            });
            Thread t2 = new Thread(() -> {
                myThread.print(2, 3, 'B');
            });
            Thread t3 = new Thread(() -> {
                myThread.print(3, 4, 'C');
            });
            Thread t4 = new Thread(() -> {
                myThread.print(4, 1, 'D');
            });
            t1.start();
            t2.start();;
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println();
        }
    }
    static class MyThread{
        int n;
        int flag;

        public MyThread(int n, int flag) {
            this.n = n;
            this.flag = flag;
        }

        public void print(int flag,int nextFlag,Character ch){
            for (int i = 0; i < n; i++) {
                synchronized(this){
                    while (flag!=this.flag){
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(ch);
                    this.flag = nextFlag;
                    this.notifyAll();
                }
            }
        }
    }

}
