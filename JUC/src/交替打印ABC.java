public class 交替打印ABC {
    public static void main(String[] args) {
        SynWaitNotify synWaitNotify = new SynWaitNotify(1, 5);
        new Thread(()->{
            synWaitNotify.print(1,2,"A");
        }).start();
        new Thread(()->{
            synWaitNotify.print(2,3,"B");
        }).start();
        new Thread(()->{
            synWaitNotify.print(3,1,"C");
        }).start();

    }
}

class SynWaitNotify{
    private int flag;
    private int loopNumber;

    public SynWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag,int nextFlag,String str){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (this.flag!=waitFlag){
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
}