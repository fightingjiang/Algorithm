package com;


import java.io.IOException;
import java.nio.ByteBuffer;

public class test {

    public static void main(String[] args) throws IOException {
        String s1 = new String("a")+new String("b");
        String s3 = "ab";
        String s2 = s1.intern();
        System.out.println(s2==s3);
        System.in.read();

    }
}
