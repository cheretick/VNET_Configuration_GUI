package com.collinscode;

public class Network {
    String name, filePath;

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
}
