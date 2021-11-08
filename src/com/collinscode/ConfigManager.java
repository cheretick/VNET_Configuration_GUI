package com.collinscode;

// none of this works yet

public class ConfigManager {
    String currentCFG;

    void CFGtoGUI(String CFG) {
        // convert CFG file to editable GUI configuration
    }
    
    String GUItoCFG() {
        String CFG = "";
        // turn current network configuration into a string that can be read by V-NetLab
        return CFG;
    }

    void printCurrentCFG() {
        System.out.println(currentCFG);
    }
}
