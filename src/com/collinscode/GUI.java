package com.collinscode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.ActionListener;

public class GUI extends javax.swing.JFrame implements ActionListener {

    ConfigManager configManager;
    Network network;

    public GUI(Network network, ConfigManager configManager) {
        this.network = network;
        this.configManager = configManager;
        JFrame frame = new JFrame("VNET Configurator");
        JFileChooser fileChooser = new javax.swing.JFileChooser(".\\CFG Files");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        //JButton open = new JButton("Open CFG");
        //frame.getContentPane().add(open); // Adds Button to content pane of frame

        // menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenuItem open = new JMenuItem("Open CFG");
        open.addActionListener(this);
        JMenuItem save = new JMenuItem("Save As");
        save.addActionListener(this);
        file.add(open);
        file.add(save);


        // adding components
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.setVisible(true);
    }


    public ActionListener openFile() throws FileNotFoundException {
        JFileChooser fileChooser = new javax.swing.JFileChooser(".\\CFG Files");
        fileChooser.setDialogTitle("Open a configuration file...");
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        System.out.println(file.toString());
        network.setFilePath(file.toString());
        configManager.loadCFGtoGUI(network, file.toString());

        return null;
    }

    public void saveFile() throws IOException {
        JFileChooser fileChooser = new javax.swing.JFileChooser(".\\CFG Files");
        fileChooser.setDialogTitle("Open a configuration file...");
        fileChooser.showSaveDialog(null);
        File file = fileChooser.getSelectedFile();
        System.out.println(file.toString());
        network.setFilePath(file.toString());
        configManager.saveGUItoCFG(network, file.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        System.out.println(com);

        if (com.equals("Open CFG")) {
            try {
                openFile();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (com.equals("Save As")) {
            try {
                saveFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
