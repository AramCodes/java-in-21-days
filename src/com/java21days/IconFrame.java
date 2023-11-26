package com.java21days;

import javax.swing.*;

public class IconFrame extends JFrame {
    JButton load, save, subscribe, unsubscribe;

    public IconFrame() {
        super("Icon Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
//  creates icons
        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subscribeIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubscribeIcon = new ImageIcon("unsubscribe.gif");
//  creates buttons
        load = new JButton("Load", loadIcon);
        load = new JButton("Save", saveIcon);
        load = new JButton("Subscribe", subscribeIcon);
        load = new JButton("Unsubscribe", unsubscribeIcon);
//        adds buttons to panel
        panel.add(load);
        panel.add(save);
        panel.add(subscribe);
        panel.add(unsubscribe);
//        add panel to a frame
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        IconFrame ike = new IconFrame();
    }

}
