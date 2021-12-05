package com.collinscode;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {

    public void readFile (String filePath, Network network) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        String[] lineRead;
        String[] infSplit = null;
        String[] nameSplit = null;
        HashMap<String, VM> vmMap = new HashMap<>();
        HashMap<String, String> solutionMap = new HashMap<>();
        ArrayList<String> hubInfList = new ArrayList<>();
        String vmName = "", os = "", ver = "", src = "", eth0 = "", eth1 = "",
                eth2 = "", hubName = "", inf = "", subnet = "", netmask = "", connString = "", connString2 = "";
        int infIndex;


        while (input.hasNext()) {
            lineRead = input.nextLine().split(" ");

            //System.out.println(Arrays.toString(lineRead)); //used for debugging

            if (lineRead[0].contains("vm")) {
                vmName = lineRead[1];
                lineRead = input.nextLine().split(" ");

                //some of the examples don't have a space between "os" and the colon
                if (lineRead[lineRead.length - 2].equals("os:") |
                        lineRead[lineRead.length - 3].equals("os")) {
                    os = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                if (lineRead[lineRead.length - 3].equals("ver")) {
                    ver = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                if (lineRead[lineRead.length - 3].equals("src")) {
                    src = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                if (lineRead[lineRead.length - 3].equals("eth0")) {
                    eth0 = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                try { // this exception block makes the parser ignore an out-of-bounds
                    // exception caused by a VM not having an associated eth1 or eth2
                    if (lineRead[lineRead.length - 3].equals("eth1")) {
                        eth1 = lineRead[lineRead.length - 1];
                        lineRead = input.nextLine().split(" ");
                    }

                    if (lineRead[lineRead.length - 3].equals("eth2")) {
                        eth2 = lineRead[lineRead.length - 1];
                        lineRead = input.nextLine().split(" ");
                    }
                } catch (IndexOutOfBoundsException ex) {
                    // do nothing
                }

                //System.out.println(vmName + " " + os + " " + ver + " "
                //        + src + " " + eth0 + " " + eth1 + " " + eth2); //used for debugging
                if (eth2 != "") {
                    VM item = new VM(vmName, os, ver, src, eth0, eth1, eth2, network);
                    vmMap.put(vmName, item);
                } else if (eth1 != "" && eth2 == "") {
                    VM item = new VM(vmName, os, ver, src, eth0, eth1, network);
                    vmMap.put(vmName, item);
                } else {
                    VM item = new VM(vmName, os, ver, src, eth0, network);
                    vmMap.put(vmName, item);
                }

                //these need to be reset so they don't flow into the next VM
                eth1 = "";
                eth2 = "";

                //System.out.println(vmMap.get(vmName)); //used for debugging

            } else if (lineRead[0].contains("hub")) {
                //System.out.println("hub!!!"); //used for debugging
                hubName = lineRead[1];
                infIndex = 9999999;
                lineRead = input.nextLine().split(" ");

                for (int i = 0; i < lineRead.length; i++) {
                    if (lineRead[i].equals("inf")) {
                        infIndex = i;
                    }
                    if (i > infIndex + 1) {
                        hubInfList.add(lineRead[i].replaceAll(",", ""));
                        infSplit = lineRead[i].split("\\.");
                        infSplit[1] = infSplit[1].replaceAll(",", "");
                        //System.out.println(infSplit[0]); //used for debugging
                        //System.out.println(infSplit[1]); //used for debugging
                        solutionMap.put(infSplit[0], infSplit[1]);

                    }

                }

                //System.out.println(hubInfList); //used for debugging
                lineRead = input.nextLine().split(" ");

                if (lineRead[lineRead.length - 3].equals("subnet")) {
                    subnet = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                if (lineRead[lineRead.length - 3].equals("netmask")) {
                    netmask = lineRead[lineRead.length - 1];
                    lineRead = input.nextLine().split(" ");
                }

                ArrayList hubInfListClone = new ArrayList();
                hubInfListClone = (ArrayList) hubInfList.clone();

                Hub item = new Hub(hubName, hubInfListClone, subnet, netmask, network);
                hubInfList.clear();

            } else if (lineRead[0].contains("partial_solution")){
                //System.out.println("partial-solution!!!");
                lineRead = input.nextLine().split(" ");

                while (lineRead[0].startsWith("(")) {
                    nameSplit = lineRead[0].split("\\.");
                    nameSplit[0] = nameSplit[0].replaceAll("\\(", "");

                    //uses the host name from the file to figure out which VM's method to use
                    VM connection = vmMap.get(nameSplit[0]);

                    //grabs connections from "partial-solution", strips extra characters, and creates a connection
                    connString = nameSplit[0] + "." + nameSplit[1];
                    connString2 = lineRead[1].replaceAll("\\)", "");
                    connString2 = lineRead[1].replaceAll(",", "");

                    connection.addConnection(connString, connString2);

                    //System.out.println("CON: " + connection.connections); //used for debugging

                    lineRead = input.nextLine().split(" ");
                }




            } else if (lineRead[0].equals("")){
                //System.out.println("SPACE"); //used for debugging
            }
            else {
                System.out.println("-unknown-");
            }
        }


    }

}
