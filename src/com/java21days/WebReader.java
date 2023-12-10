package com.java21days;

import javax.swing.*;
import java.net.*;
import java.io.*;
public class WebReader extends JFrame {
//    networking in Java to communicate with systems on the internet in three simple ways, the first is to load an url,
//    the second is to use sockets, socket classes and ServerSocket, and the third way is to call getInputStream(), which
//    is a method that opens a connection to a URL and can extract data from that connection.

//    there is a four-step process to load a document from the web and read it line by line
//    step 1: create a URL object that represents the resource's web address
//    step 2: create and HttpURLConnection object that can load the URL and make a connection to the site hosting it.
//    step 3: use the getContent() method of that HttpURLConnection object to create an InputStreamReader object
//    step 4: use that InputStreamReader object to create a BufferReader object that can efficiently read characters from an input stream.

    JTextArea box = new JTextArea("Getting data ...");

    public WebReader() {
        super("Get Document Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,300);
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }

    void getData(String address) throws MalformedURLException {
        setTitle(address);
        URL page;
        page = new URL(address);
        StringBuilder text = new StringBuilder();
        try {
            HttpURLConnection conn = (HttpURLConnection)
                    page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader(
                    (InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in);
            box.setText("Getting data ...");
            String line;
            do {
                line = buff.readLine();
                text.append(line);
                text.append("\n");
            } while (line != null);
            box.setText(text.toString());
        } catch (IOException ioe) {
            System.out.println("IO Error:" + ioe.getMessage());
        }
    }

    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java WebReader url");
            System.exit(1);
        }
        try {
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}
