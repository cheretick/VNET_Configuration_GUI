package com.collinscode;

import java.util.ArrayList;

public class Network {
    String name, filePath;
    ArrayList<VM> vmList = new ArrayList<>();
    ArrayList<Hub> hubList = new ArrayList<>();

    Network(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    public ArrayList<VM> getVMList() {
        return vmList;
    }

    public ArrayList<Hub> getHubList() {
        return hubList;
    }

    public void addVM(VM vm) {
        vmList.add(vm);
    }

    public void addHub(Hub hub) {
        hubList.add(hub);
    }

    public void clearLists () {
        vmList.clear();
        hubList.clear();
    }
}
