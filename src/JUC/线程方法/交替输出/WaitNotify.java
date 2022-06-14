package JUC.线程方法.交替输出;

/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 20:08 2021/7/15
 */
public class WaitNotify {
    private int flag;
    private  int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waiFlag,int nextFlag,String str){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (this.flag!=waiFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1, 5);
        new Thread(()->{
            waitNotify.print(1,2,"a");
        }).start();
        new Thread(()->{
            waitNotify.print(2,3,"b");
        }).start();
        new Thread(()->{
            waitNotify.print(3,1,"c");
        }).start();
    }
}
