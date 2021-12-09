package com.collinscode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class VMMenu extends javax.swing.JFrame implements ActionListener {

    Network network;
    JLabel name, os, ver, src, eth0, eth1, eth2;
    JTextField nameField, osField, verField, srcField, eth0Field, eth1Field, eth2Field;
    HashMap<String, VM> vmMap = new HashMap<>();

    VMMenu(Network network) {
        this.network = network;
        JFrame frame = new JFrame("VM Menu");
        frame.setTitle("VM");
        frame.setBounds(300,90,600,400);
        setResizable(false);


        // components
        name = new JLabel("Name");
        nameField = new JTextField(15);
        os = new JLabel("OS");
        osField = new JTextField(15);
        ver = new JLabel("Version");
        verField = new JTextField(15);
        src = new JLabel("Source");
        srcField = new JTextField(15);
        eth0 = new JLabel("Eth0");
        eth0Field = new JTextField(15);
        eth1 = new JLabel("Eth1");
        eth1Field = new JTextField(15);
        eth1Field.setText("");
        eth2 = new JLabel("Eth2");
        eth2Field = new JTextField(15);
        eth2Field.setText("");
        JLabel blank = new JLabel("");
        JButton submit = new JButton("SUBMIT");

        // panel
        JPanel panel = new JPanel(new GridLayout(8,2));
        panel.add(name);
        panel.add(nameField);
        panel.add(os);
        panel.add(osField);
        panel.add(ver);
        panel.add(verField);
        panel.add(src);
        panel.add(srcField);
        panel.add(eth0);
        panel.add(eth0Field);
        panel.add(eth1);
        panel.add(eth1Field);
        panel.add(eth2);
        panel.add(eth2Field);
        panel.add(blank);
        panel.add(submit);

        // set action to submit
        submit.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String os = osField.getText();
        String ver = verField.getText();
        String src = srcField.getText();
        String eth0 = eth0Field.getText();
        String eth1 = eth1Field.getText();
        String eth2 = eth2Field.getText();

        if (!eth2.equals("")) {
            VM item = new VM(name, os, ver, src, eth0, eth1, eth2, network);
            vmMap.put(name, item);
        } else if (!eth1.equals("")) {
            VM item = new VM(name, os, ver, src, eth0, eth1, network);
            vmMap.put(name, item);
        } else {
            VM item = new VM(name, os, ver, src, eth0, network);
            vmMap.put(name, item);
        }
    }
}
