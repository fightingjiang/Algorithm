//public class ABAWaitNotify {
//    public static void main(String[] args) {
//        Symbol symbol = new Symbol();
//        new Thread(()->{
//            symbol.run("A",1,2);
//        }).start();
//        new Thread(()->{
//            symbol.run("B",2,3);
//        }).start();
//        new Thread(()->{
//            symbol.run("C",3,1);
//        }).start();
//    }
//}
//
//class Symbol{
//    public synchronized void run(String string, int flag, int nextFlag){
//        for (int i = 0; i < loopNumber; i++) {
//            while (flag!=this.flag){
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(string);
//            this.flag = nextFlag;
//            this.notifyAll();
//        }
//    }
//
//
//    private int flag = 1;
//
//    private int loopNumber = 5;
//
//    public int getFlag() {
//        return flag;
//    }
//
//    public int getLoopNumber() {
//        return loopNumber;
//    }
//
//    public void setFlag(int flag) {
//        this.flag = flag;
//    }
//
//    public void setLoopNumber(int loopNumber) {
//        this.loopNumber = loopNumber;
//    }
//}