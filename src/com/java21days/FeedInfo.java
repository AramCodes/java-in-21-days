package com.java21days;

import javax.swing.*;
import java.awt.*;

public class FeedInfo extends JFrame {
    private final JLabel nameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
    private final JTextField name;
    private final JLabel urlLabel = new JLabel("URL: ", SwingConstants.RIGHT);
    private final JTextField url;

    private final JLabel typeLabel = new JLabel("Type: ", SwingConstants.RIGHT);
    private final JTextField type;

    public FeedInfo() {
        super("Feed Information");
        setSize(400,145);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
//        site name
        String response1 = JOptionPane.showInputDialog(null, "Enter The Site Name");
        name = new JTextField(response1, 20);
//        site address
        String response2 = JOptionPane.showInputDialog(null, "Enter The Site Address");
        url = new JTextField(response2, 20);
//        site type
        String[] choices = {"Personal", "Commercial", "Unknown" };
        int response3 = JOptionPane.showOptionDialog(null, "What Type Of Site IS IT?","Site Type", 0,
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        type = new JTextField(choices[response3],20);

        setLayout(new GridLayout(3,2));
        add(nameLabel);
        add(name);
        add(urlLabel);
        add(url);
        add(typeLabel);
        add(type);
        setLookAndFeel();
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            System.err.println("Couldn't use the system look and feel: " + e);
        }
    }

    public static void main(String[] args) {
        FeedInfo frame = new FeedInfo();
    }
}
