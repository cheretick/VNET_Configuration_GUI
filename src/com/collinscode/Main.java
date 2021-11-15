package com.collinscode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // based off of "network1.cfg"

        Network network1 = new Network("network1", "C:\\Networks\\");

        VM gemini = new VM("Gemeni", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.10.3");
        VM nfs = new VM("Nfs", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.10.2");
        VM intfw = new VM("Intfw", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.20.2", "192.168.10.1");
        VM extfw = new VM("Extfw", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.40.1", "192.168.30.1", "192.168.20.1");
        VM dmz = new VM("Dmz", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.30.2");
        VM defaultGW = new VM("DefaultGW", "LINUX", "7.3", "/srv/VMLibrary/JeOS", "192.168.40.2");

        ArrayList<String> hub1Inf = new ArrayList<>();
        hub1Inf.add("Gemini.eth0");
        hub1Inf.add("Nfs.eth0");
        hub1Inf.add("Intfw.eth1");

        Hub hub1 = new Hub("hub1", hub1Inf, "192.168.10.0", "255.255.255.0");

        ArrayList<String> hub2Inf = new ArrayList<>();
        hub2Inf.add("Extfw.eth2");
        hub2Inf.add("Intfw.eth0");

        Hub hub2 = new Hub("hub2", hub2Inf, "192.168.20.0", "255.255.255.0");

        ArrayList<String> hub3Inf = new ArrayList<>();
        hub3Inf.add("Dmz.eth0");
        hub3Inf.add("Extfw.eth1");

        Hub hub3 = new Hub("hub3", hub3Inf, "192.168.30.0", "255.255.255.0");

        ArrayList<String> hub4Inf = new ArrayList<>();
        hub4Inf.add("DefaultGW.eth0");
        hub4Inf.add("Extfw.eth0");

        Hub hub4 = new Hub("hub4", hub4Inf, "192.168.40.0", "255.255.255.0");

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

        System.out.println("\n\n\tnetwork1.cfg: \n");

        System.out.println(gemini.outputString());
        System.out.println(nfs.outputString());
        System.out.println(intfw.outputString());
        System.out.println(extfw.outputString());
        System.out.println(dmz.outputString());
        System.out.println(defaultGW.outputString());
        System.out.println(hub1.outputString());
        System.out.println(hub2.outputString());
        System.out.println(hub3.outputString());
        System.out.println(hub4.outputString());
        System.out.println("partial_solution {"); // need to fix comma output
        System.out.println(gemini.outputPartialSolutionString());
        System.out.println(nfs.outputPartialSolutionString());
        System.out.println(intfw.outputPartialSolutionString());
        System.out.println(extfw.outputPartialSolutionString());
        System.out.println(dmz.outputPartialSolutionString());
        System.out.println(defaultGW.outputPartialSolutionString());
        System.out.println("}");





        // based off of "network2.cfg"

        Network network2 = new Network("network2", "C:\\Networks\\");

        VM host1 = new VM("host1", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.3");
        VM host2 = new VM("host2", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.2");

        ArrayList<String> hub1Inf2 = new ArrayList<>();
        hub1Inf.add("host1.eth0");
        hub1Inf.add("host2.eth0");

        Hub hub1_2 = new Hub("hub1", hub1Inf2, "192.168.10.0", "255.255.255.0");

        host1.addConnection("host1.eth0", "v3.vinf20");
        host2.addConnection("host2.eth0", "v3.vinf20");

        // network2.cfg output

        System.out.println("\n\n\tnetwork2.cfg: \n");

        System.out.println(host1.outputString());
        System.out.println(host2.outputString());
        System.out.println(hub1_2.outputString());
        System.out.println("partial_solution {");
        System.out.println(host1.outputPartialSolutionString());
        System.out.println(host2.outputPartialSolutionString());
        System.out.println("}");





    }
}
