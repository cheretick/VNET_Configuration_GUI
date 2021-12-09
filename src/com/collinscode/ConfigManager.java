package com.collinscode;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigManager {
    String GUItoCFG(Network network) {
        String CFG = "";
        ArrayList<VM> vmList = network.getVMList();
        ArrayList<Hub> hubList = network.getHubList();

        for (int i = 0; i < vmList.size(); i++) {
            VM temp = vmList.get(i);
            CFG += temp.outputString() + "\n";
        }

        for (int i = 0; i < hubList.size(); i++) {
            Hub temp = hubList.get(i);

            System.out.println(temp.getInf());
            CFG += temp.outputString() + "\n";
        }

        CFG += "partial_solution {\n";

        for (int i = 0; i < vmList.size(); i++) {
            VM temp = vmList.get(i);
            CFG += temp.outputPartialSolutionString();
            if (i < vmList.size() - 1) {
                CFG += ",\n";
            } else {
                CFG += "\n";
            }
        }

        CFG += "}";

        //removes double "s
        CFG = CFG.replaceAll("\"\"", "\"");

        return CFG;
    }

    void loadCFGtoGUI(Network network, String filePath) throws FileNotFoundException {
        Parser parser = new Parser();
        // reset network
        parser.clearHash();
        network.clearLists();
        parser.readFile(filePath, network);
    }

    void saveGUItoCFG(Network network, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(GUItoCFG(network));
        writer.close();
    }
}
