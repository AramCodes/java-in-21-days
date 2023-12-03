package com.java21days;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements FocusListener {

    JTextField value1, value2, sum;
    JLabel plus, equals;

    public Calculator() {
        super("Two Number Addition Calculator");
        setSize(350, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);
//        creates components for adding
        value1 = new JTextField("0", 5);
        plus = new JLabel("+");
        value2 = new JTextField("0", 5);
//        creates equal sign component for all operations
        equals = new JLabel("=");

        sum = new JTextField("0", 5);

//        adds listeners
        value1.addFocusListener(this);
        value2.addFocusListener(this);

//        sets up result field
        sum.setEditable(false);

//        uses add method to piece together GUI
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        try {
            float total = Float.parseFloat(value1.getText()) +
                    Float.parseFloat(value2.getText());
            sum.setText("" + total);
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusGained(e);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.err.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments) {
        Calculator.setLookAndFeel();
        Calculator frame = new Calculator();
    }
}
