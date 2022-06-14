package JVM;


/**
 * @Author: jiangzhihao
 * @Description:
 * @Data: create in 14:35 2021/7/18
 */
public class test {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Object());
        }
    }
}
