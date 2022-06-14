package com.Reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class softReference {
    public static void main(String[] args) {
        ArrayList<SoftReference<byte[]>> list = new ArrayList<>();
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();



    }
}
