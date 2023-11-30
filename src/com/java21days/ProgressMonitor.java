package com.java21days;

import javax.swing.*;
import java.awt.*;

public class ProgressMonitor extends JFrame {
    JProgressBar current;
    JTextArea out;
    JButton find ;
    int num = 0;



    public ProgressMonitor() {
        super("Progress Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 125);
        JLabel label = new JLabel("Your computer is going to crash once this progress bar hits 100%");
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(label);
        add(current);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            num += 95;
        }
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor.setLookAndFeel();
        ProgressMonitor frame = new ProgressMonitor();
        frame.setVisible(true);
        frame.iterate();
    }
}
