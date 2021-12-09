package com.collinscode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public void network1ToString() throws IOException {
        // based off of "network1.cfg"

        // creates Network object
        Network network1 = new Network("network1", "C:\\Networks\\");

        // creates VM objects
        VM gemini = new VM("Gemeni", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.10.3", network1);
        VM nfs = new VM("Nfs", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.10.2", network1);
        VM intfw = new VM("Intfw", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.20.2", "192.168.10.1", network1);
        VM extfw = new VM("Extfw", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.40.1", "192.168.30.1", "192.168.20.1", network1);
        VM dmz = new VM("Dmz", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.30.2", network1);
        VM defaultGW = new VM("DefaultGW", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.40.2", network1);

        // Hub's inf parameter needs to be passed an ArrayList<String> so it must be made ahead of time
        ArrayList<String> hub1Inf = new ArrayList<>();
        hub1Inf.add("Gemini.eth0");
        hub1Inf.add("Nfs.eth0");
        hub1Inf.add("Intfw.eth1");

        // creates Hub object
        Hub hub1 = new Hub("hub1", hub1Inf, "192.168.10.0", "255.255.255.0", network1);


        ArrayList<String> hub2Inf = new ArrayList<>();
        hub2Inf.add("Extfw.eth2");
        hub2Inf.add("Intfw.eth0");

        Hub hub2 = new Hub("hub2", hub2Inf, "192.168.20.0", "255.255.255.0", network1);

        ArrayList<String> hub3Inf = new ArrayList<>();
        hub3Inf.add("Dmz.eth0");
        hub3Inf.add("Extfw.eth1");

        Hub hub3 = new Hub("hub3", hub3Inf, "192.168.30.0", "255.255.255.0", network1);

        ArrayList<String> hub4Inf = new ArrayList<>();
        hub4Inf.add("DefaultGW.eth0");
        hub4Inf.add("Extfw.eth0");

        Hub hub4 = new Hub("hub4", hub4Inf, "192.168.40.0", "255.255.255.0", network1);

        // creates connections for the "partial_solution" portion
        gemini.addConnection("Gemini.eth0", "v2.vinf21");
        nfs.addConnection("Nfs.eth0", "v2.vinf21");
        intfw.addConnection("Intfw.eth1", "v2.vinf21");
        extfw.addConnection("Extfw.eth2", "v2.vinf22");
        intfw.addConnection("Intfw.eth0", "v2.vinf22");
        extfw.addConnection("Extfw.eth1", "v2.vinf23");
        dmz.addConnection("Dmz.eth0", "v2.vinf23");
        extfw.addConnection("Extfw.eth0", "v2.vinf24");
        defaultGW.addConnection("DefaultGW.eth0", "v2.vinf24");


        // network1.cfg output

        // creates configManager object
        ConfigManager configManager = new ConfigManager();

        //prints CFG string to console
        System.out.println(configManager.GUItoCFG(network1));

        //saves CFG string to txt file
        configManager.saveGUItoCFG(network1,".\\test.cfg");
    }

    public void network2ToString() throws IOException {
        // based off of "network2.cfg"

        //creates network object
        Network network2 = new Network("network2", ".\\Networks\\");

        //creates host1 and host2 objects
        VM host1 = new VM("host1", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.3", network2);
        VM host2 = new VM("host2", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.2", network2);

        //creates an array list to pass into the Hub's inf parameter
        ArrayList<String> hub1Inf2 = new ArrayList<>();
        hub1Inf2.add("host1.eth0");
        hub1Inf2.add("host2.eth0");

        //creates Hub object
        Hub hub1 = new Hub("hub1", hub1Inf2, "192.168.10.0", "255.255.255.0", network2);

        //creates connections for partial_solution
        host1.addConnection("host1.eth0", "v3.vinf20");
        host2.addConnection("host2.eth0", "v3.vinf20");

        //creates configManager object
        ConfigManager configManager = new ConfigManager();

        //prints CFG string to console
        System.out.println(configManager.GUItoCFG(network2));

        //saves CFG string to txt file
        configManager.saveGUItoCFG(network2,".\\test.cfg");

        // disconnect ports
        host1.removeConnection("host1.eth0");
        host2.removeConnection("host2.eth0");
    }

    public void network() {
        // this test only tests very basic methods from the Network class
        Network test = new Network("test", "C:\\Networks\\");
        test.setName("Test");
        test.setFilePath("C:\\Networks\\testing\\");
        System.out.println("\n\n\tnetwork() test:\n\n" + test.getName());
        System.out.println(test.getFilePath());
    }

    public void network1FromFile() throws FileNotFoundException {
        // this test shows how to import from a cfg file

        // creates Network object
        Network network1 = new Network("network1", ".\\network1.cfg");

        // creates ConfigManager object
        ConfigManager configManager = new ConfigManager();

        // this method uses the parser to import the network topology from a cfg file
        configManager.loadCFGtoGUI(network1, network1.getFilePath());
    }

    public void network2FromFile() throws FileNotFoundException {
        Network network2 = new Network("network2", ".\\network2.cfg");
        ConfigManager configManager = new ConfigManager();
        configManager.loadCFGtoGUI(network2, network2.getFilePath());
    }

    public void network1FromFileToFile() throws IOException {
        //network1.cfg input (same as Test.network1FromFile()
        Network network1 = new Network("network1", ".\\network1.cfg");
        ConfigManager configManager = new ConfigManager();
        configManager.loadCFGtoGUI(network1, network1.getFilePath());

        // network1.cfg output to test.cfg

        // prints CFG string to console
        System.out.println(configManager.GUItoCFG(network1));

        // saves CFG string to txt file
        configManager.saveGUItoCFG(network1,".\\test.cfg");
    }

    public void network2FromFileToFile() throws IOException {
        //network2.cfg input
        Network network2 = new Network("network2", ".\\network2.cfg");
        ConfigManager configManager = new ConfigManager();
        configManager.loadCFGtoGUI(network2, network2.getFilePath());

        // network1.cfg output to test.cfg

        //prints CFG string to console
        System.out.println(configManager.GUItoCFG(network2));

        //saves CFG string to txt file
        configManager.saveGUItoCFG(network2,".\\test.cfg");
    }
}
