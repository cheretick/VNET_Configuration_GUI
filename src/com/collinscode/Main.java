package com.collinscode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Test test = new Test();
        test.network1(); // test I/O based on network1.cfg
        test.network2(); // test I/O based on network2.cfg
        test.network(); // tests the Network class
    }
}
