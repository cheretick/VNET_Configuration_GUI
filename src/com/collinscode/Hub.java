package com.collinscode;

import java.util.ArrayList;

public class Hub {
    String name, subnet, netmask;
    ArrayList<String> inf;

    Hub(String name, ArrayList<String> inf, String subnet, String netmask) {
        this.name = name;
        this.inf = inf;
        this.subnet = subnet;
        this.netmask = netmask;

        System.out.println(this.name + " has been created successfully");
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
