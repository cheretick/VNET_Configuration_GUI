package com.collinscode;

public class VM {
    String name, os, ver, src, eth0, eth1, eth2;

    // There are three constructors, so you can initialize a VM with 1, 2, or 3 ethernet interfaces

    VM(String name, String os, String ver, String src, String eth0) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;

        System.out.println(this.name + " has been created successfully");
    }

    VM(String name, String os, String ver, String src, String eth0, String eth1) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;
        this.eth1 = eth1;

        System.out.println(this.name + " has been created successfully");
    }

    VM(String name, String os, String ver, String src, String eth0, String eth1, String eth2) {
        this.name = name;
        this.os = os;
        this.ver = ver;
        this.src = src;
        this.eth0 = eth0;
        this.eth1 = eth1;
        this.eth2 = eth2;

        System.out.println(this.name + " has been created successfully");
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