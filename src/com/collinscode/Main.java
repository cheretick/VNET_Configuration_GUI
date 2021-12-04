package com.collinscode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Test test = new Test();
        //manually creates network topology using methods then outputs/saves to test.cfg
        //test.network1ToString();
        //test.network2ToString();

        //imports network topology from CFG text file
        //test.network1FromFile();
        //test.network2FromFile();

        //test.network1FromFileToFile();
        test.network2FromFileToFile();
        //Network network2 = new Network("network2", "C:\\Networks\\");

        //VM host1 = new VM("host1", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.3", network2);


    }
}
