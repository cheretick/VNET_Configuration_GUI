package com.collinscode;

import java.util.ArrayList;

public class Hub {
    String name, subnet, netmask;
    Network network;
    ArrayList<String> inf;

    Hub(String name, ArrayList<String> inf, String subnet, String netmask, Network network) {
        this.name = name;
        this.inf = inf;
        this.subnet = subnet;
        this.netmask = netmask;
        this.network = network;
        network.addHub(this);

        System.out.println(this.name + " has been created successfully");
    }

    public String outputString() {
        String output = "";
        output += "hub " + this.name + " { \n\t\tinf: ";
        for (int i = 0; i < this.inf.size(); i++) {
            output += this.inf.get(i);
            if (i != this.inf.size() - 1) {
                output += ", ";
            }
        }
        output += "\n\t\tsubnet : \"" + this.subnet + "\"\n\t\tnetmask : \"" + this.netmask + "\"\n}\n";
        return output;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInf(ArrayList<String> inf) {
        this.inf = inf;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getInf() {
        return inf;
    }

    public String getSubnet() {
        return subnet;
    }

    public String getNetmask() {
        return netmask;
    }
}
