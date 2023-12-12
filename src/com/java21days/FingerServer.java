package com.java21days;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.*;

public class FingerServer {
//    in Java blocking refers to a statement that must completed execution before anything else happens in the program
//    you can creat networking connections and read to and write from them using nonblocking methods
//    1. associate a socket channel with an input stream or an output stream
//    2. configure the channel to recognize the kind of networking events you want to monitor, such as new connections,
//    attempts to read over the channel, and attempts to write data
//   3. call a method to open the channel. Because the method is non-blocking, the program continues executing so that you can handle other tasks.
//   If one of the networking events you are monitoring takes place, your program is notified; that is, a method associated with the event is called.

    public FingerServer() {
        try {
            // Creates a non-blocking server socket channel
            ServerSocketChannel sock = ServerSocketChannel.open();
            sock.configureBlocking(false);

            // Sets the host and port to monitor
            InetSocketAddress server = new InetSocketAddress(
                    "localhost", 79);
            ServerSocket socket = sock.socket();
            socket.bind(server);

            // Creates the selector and registers it on the channel
            Selector selector = Selector.open();
            sock.register(selector, SelectionKey.OP_ACCEPT);

            // Loops forever, looking for client connections
            while (true) {
                // Wait for a connection
                selector.select();

                // Gets list of selection keys with pending events
                Set keys = selector.selectedKeys();
                Iterator it = keys.iterator();

                // Handles each key
                while (it.hasNext()) {

                    // Gets the key and remove it from the iteration
                    SelectionKey sKey = (SelectionKey) it.next();

                    it.remove();
                    if (sKey.isAcceptable()) {

                        // Creates a socket connection with client
                        ServerSocketChannel selChannel =
                                (ServerSocketChannel) sKey.channel();
                        ServerSocket sSock = selChannel.socket();
                        Socket connection = sSock.accept();

                        // Handles the Finger request
                        handleRequest(connection);
                        connection.close();
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void handleRequest(Socket connection)
            throws IOException {

        // Set up input and output
        InputStreamReader isr = new InputStreamReader (
                connection.getInputStream());
        BufferedReader is = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter(new
                BufferedOutputStream(connection.getOutputStream()),
                false);

        // Output server greeting
        pw.println("Nio Finger Server");
        pw.flush();

        // Handle user input
        String outLine = null;
        String inLine = is.readLine();

        if (!inLine.isEmpty()) {
            outLine = inLine;
        }
        readPlan(outLine, pw);

        // Clean up
        pw.flush();
        pw.close();
        is.close();
    }

    private void readPlan(String userName, PrintWriter pw) {
        try {
            FileReader file = new FileReader(userName + ".plan");
            BufferedReader buff = new BufferedReader(file);
            boolean eof = false;

            pw.println("\nUser name: " + userName + "\n");

            while (!eof) {
                String line = buff.readLine();

                if (line == null) {
                    eof = true;
                } else {
                    pw.println(line);
                }
            }

            buff.close();
        } catch (IOException e) {
            pw.println("User " + userName + " not found.");
        }
    }

    public static void main(String[] arguments) {
        FingerServer nio = new FingerServer();
    }
}
