package 数学;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        //思想：用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
