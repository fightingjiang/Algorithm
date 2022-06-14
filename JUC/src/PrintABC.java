public class PrintABC {
    public static void main(String[] args) {
        SynObject synObject = new SynObject(1, 5);
        new Thread(()->{
            synObject.print("A",1,2);
        }).start();
        new Thread(()->{
            synObject.print("B",2,3);
        }).start();
        new Thread(()->{
            synObject.print("C",3,1);
        }).start();

    }
}

class SynObject{
    //标志位
    private int flag;
    //循环次数
    private int times;

    public SynObject(int flag, int times) {
        this.flag = flag;
        this.times = times;
    }

    public void print(String string, int flag ,int nextFlag){
        for (int i = 0; i < times; i++) {
            synchronized (this){
                while (this.flag!=flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(string);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
