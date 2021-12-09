package com.collinscode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Network network = new Network("currentNetwork", null);
        ConfigManager configManager = new ConfigManager();
        GUI gui = new GUI(network, configManager);










        // -TESTS- //

        // a Network object must be initialized for all other methods to work!
        //      each test method already includes a network object

        //Test test = new Test();

        // the tests below should give a decent idea on how to use the different methods and classes
        //      just uncomment the tests below to use them!

        // manually creates network topology using methods then outputs/saves to test.cfg
        //test.network1ToString();
        //test.network2ToString();

        // imports network topology from CFG text file
        //test.network1FromFile();
        //test.network2FromFile();

        // these tests import from a cfg file and then save the network to test.cfg
        //test.network1FromFileToFile();
        //test.network2FromFileToFile();
    }
}
