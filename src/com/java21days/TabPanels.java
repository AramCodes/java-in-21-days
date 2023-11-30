package com.java21days;

import javax.swing.*;

public class TabPanels extends JFrame {

    JProgressBar current;

    public TabPanels() {
        super("Tabbed Panes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(480, 218);
        JPanel mainSettings = new JPanel();
        JPanel advancedSettings = new JPanel();
        JPanel privacySettings = new JPanel();
        JPanel emailSettings = new JPanel();
        JPanel securitySettings = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Main", mainSettings);
        tabs.add("Advanced", advancedSettings);
        tabs.add("Privacy", privacySettings);
        tabs.add("E-mail", emailSettings);
        tabs.add("Security", securitySettings);
        add(tabs);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system "+ "look and feel:" + e);
        }
    }

    public static void main(String[] arguments) {

        TabPanels frame = new TabPanels();
        ProgressMonitor.setLookAndFeel();
        ProgressMonitor frame2 = new ProgressMonitor();
        frame2.setVisible(true);
        frame2.iterate();
    }
}
