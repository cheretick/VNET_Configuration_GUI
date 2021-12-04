package com.collinscode;

import java.util.HashMap;

public class VM {
    Network network;
    String name, os, ver, src, eth0, eth1, eth2;
    HashMap<String, String> connections = new HashMap<>();

    // There are three constructors, so you can initialize a VM with 1, 2, or 3 ethernet interfaces
    VM(String name, String os, String ver, String src, String eth0, Network network) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;
        this.network = network;
        network.addVM(this);

        System.out.println(this.name + " has been created successfully");
    }

    VM(String name, String os, String ver, String src, String eth0, String eth1, Network network) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;
        this.eth1 = eth1;
        this.network = network;
        network.addVM(this);

        System.out.println(this.name + " has been created successfully");
    }

    VM(String name, String os, String ver, String src, String eth0, String eth1, String eth2, Network network) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;
        this.eth1 = eth1;
        this.eth2 = eth2;
        this.network = network;
        network.addVM(this);

        System.out.println(this.name + " has been created successfully");
    }


    public String addConnection(String port, String connection) {
        if (connections.get(port) != null) {
            return "Port is already in use";
        } else {
            connections.put(port, connection);
        } return null;
    }

    public void removeConnection(String port) {
        connections.remove(port);
        System.out.println(port + " has been disconnected");
    }

    public String outputString() {
        String output = "";
        output += "vm " + this.name + " { \n\t\tos: " + this.os + "\n\t\tver : \"" + this.ver
                + "\"\n\t\tsrc : \"" + this.src + "\"\n\t\teth0 : \"" + this.eth0 + "\"";
        if (this.eth1 != null) { output += "\n\t\teth1 : \"" + this.eth1 + "\"";}
        if (this.eth2 != null) { output += "\n\t\teth2 : \"" + this.eth2 + "\"";}
        output += "\n}\n";
            return output;
    }

    public String outputPartialSolutionString() {
        String output = "";
        int count = 0;
        for (String port: connections.keySet()) {
            count++;
            output += "(" + this.name + "." + port + " " + connections.get(port) + ")";
            if (connections.size() != count) {
                output += ",\n";
            }
            output += "";
        }
        return output;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setEth0(String eth0) {
        this.eth0 = eth0;
    }

    public void setEth1(String eth1) {
        this.eth1 = eth1;
    }

    public void setEth2(String eth2) {
        this.eth2 = eth2;
    }

    public String getName() {
        return name;
    }

    public String getOs() {
        return os;
    }

    public String getVer() {
        return ver;
    }

    public String getSrc() {
        return src;
    }

    public String getEth0() {
        return eth0;
    }

    public String getEth1() {
        return eth1;
    }

    public String getEth2() {
        return eth2;
    }

}
