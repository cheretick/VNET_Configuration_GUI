package com.collinscode;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        /*
        Test test = new Test();
        test.network1(); // test I/O based on network1.cfg
        test.network2(); // test I/O based on network2.cfg
        test.network(); // tests the Network class

         */

        //Network network2 = new Network("network2", "G:\\School\\2021 FALL\\CSET 3600\\JavaFiles\\VNET_Configuration_GUI\\network2.cfg");

        Network network1 = new Network("network1", "G:\\School\\2021 FALL\\CSET 3600\\JavaFiles\\VNET_Configuration_GUI\\network1.cfg");
        Parser parser = new Parser();

        parser.readFile(network1.getFilePath());
    }
}
