package com.collinscode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // just testing things out based off of "network2.cfg" from BlackBoard

	   Network test = new Network("test", "C:\\Networks\\");

       VM host1 = new VM("host1", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.3");
       VM host2 = new VM("host2", "WINDOWS", "7", "/srv/VMLibrary/win7", "192.168.10.2");

       ArrayList<String> hub1Inf = new ArrayList<>();
       hub1Inf.add("host1.the0");
       hub1Inf.add("host2.the0");

       Hub hub1 = new Hub("hub1", hub1Inf, "192.168.10.0", "255.255.255.0");

    }
}
