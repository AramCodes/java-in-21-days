package com.java21days;

import javax.swing.*;
import java.awt.*;

public class Bunch extends JFrame {

    public Bunch() {
        super("Calendar");
        setSize(520,260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel pane = new JPanel();
        GridLayout family = new GridLayout(3, 3, 10, 10);
        pane.setLayout(family);
        JButton jan = new JButton("January");
        JButton feb = new JButton("February");
        JButton mar = new JButton("March");
        JButton apr = new JButton("April");
        JButton may = new JButton("May");
        JButton jun = new JButton("June");
        JButton jul = new JButton("July");
        JButton aug = new JButton("August");
        JButton sep = new JButton("September");
        JButton oct = new JButton("October ");
        JButton nov = new JButton("November");
        JButton dec = new JButton("December");
        pane.add(jan);
        pane.add(feb);
        pane.add(mar);
        pane.add(apr);
        pane.add(may);
        pane.add(jun);
        pane.add(jul);
        pane.add(aug);
        pane.add(sep);
        pane.add(oct);
        pane.add(nov);
        pane.add(dec);
        add(pane);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }

    public static void main(String[] args) {
        Bunch.setLookAndFeel();
        Bunch frame = new Bunch();
    }
}
