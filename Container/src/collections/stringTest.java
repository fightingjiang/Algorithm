package collections;

import java.util.Arrays;
import java.util.Collections;

public class stringTest {
    public static void main(String[] args) {
        String s = new String();
        s = "jian     gzhihao  ";
        System.out.println(s.replaceAll(" ", ""));
        StringBuffer buffer = new StringBuffer(s);
        System.out.println(s.trim());//去掉开始结尾的空格  并删除任何前导和尾随空格。
        System.out.println(s.substring(0, s.length() - 1));//
        int[] nums = {1,2};
        String valueOf = s.valueOf(nums);  //valueOf 将其他类型数据转换成string
        System.out.println(Integer.parseInt("20"));  //其他数据类型转string   通过引用数据类型
        System.out.println(s.concat("niu"));   //末尾添加
        System.out.println(s.indexOf("a")); //字符(字符串)从前往后第一次出现的坐标
        System.out.println(s.lastIndexOf("a"));   //从后往前
        String[] as = s.split("a");
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }
        String[] as1 = s.split("a", 10);//分割的最大下标
        for (int i = 0; i < as1.length; i++) {
            System.out.println(as1[i]);
        }
    }
}
