package com.java21days;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
public class DiceRoller extends JFrame implements ActionListener, PropertyChangeListener{
//  The table for dice-roll results
    JTextField[] total = new JTextField[16];
//    creates the roll button
    JButton roll;
//    sets the number of times to roll
    JTextField quantity;
//    The swing worker
    DiceWorker worker;

    public DiceRoller() {
        super("Dice Roller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 200);
//        sets up top row
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1, 16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {
            // creates a text field and label
            total[i] = new JTextField("0", 4);
            JLabel label = new JLabel((i + 3) + ": ");
            // creates the cell in the grid
            JPanel cell = new JPanel();
            cell.add(label);
            cell.add(total[i]);
            // adds the cell to the top row
            topPane.add(cell);
        }

        // sets up bottom row
        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Times to Roll: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Roll");
        roll.addActionListener(this);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        // sets up frame
        GridLayout frameGrid = new GridLayout(2, 1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int timesToRoll;
        try {
            // turns off the button
            timesToRoll = Integer.parseInt(quantity.getText());
            roll.setEnabled(false);
            // sets up the worker that will roll the dice
            worker = new DiceWorker(timesToRoll);
            // adds a listener that monitors the worker
            worker.addPropertyChangeListener(this);
            // starts the worker
            worker.execute();
        } catch (NumberFormatException exc) {
            System.out.println(exc.getMessage());
        }
    }
    // responds when the worker's task is completed
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            // gets the worker's dice-roll results
            int[] result = (int[]) worker.get();
            // stores the results in the text fields
            for (int i = 0; i < result.length; i++) {
                total[i].setText("" + result[i]);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println("Couldn't roll the dice");
        }
    }

    public static void main(String[] arguments) {
        DiceRoller.setLookAndFeel();
        DiceRoller app = new DiceRoller();
    }
}
