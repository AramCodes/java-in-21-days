package com.java21days;

import java.io.*;
import java.net.*;
import java.util.*;
public class Finger {
//    to open a socket the syntax is Socket connection = new Socket(hostName, portNumber) after creating a socket
//    a timeout value must be set to limit the amount of time the data has to arrive (connection.setSOTimeOut(ms))
//    if the timeout in ms is reached an InterruptedIOException is thrown which at that point if you use a try-catch block
//    you can either close the socket or try to establish it again. if no timeout is used there is a chance the session may hang indefinitely

    public static void main(String[] args) {
        String user;
        String host;

        if ((args.length == 1) && (args[0].contains("@"))) {
            StringTokenizer split = new StringTokenizer(args[0], "@");
            user = split.nextToken();
            host = split.nextToken();
        } else {
            System.out.println("Usage: java Finger user@host");
            return;
        }

        try (Socket digit = new Socket(host, 79);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(digit.getInputStream()))
        ) {

            digit.setSoTimeout(20000);
            PrintStream out = new PrintStream(
                    digit.getOutputStream());
            out.print(user + "\015\012");
// eof = end of file
            boolean eof = false;
            while (!eof) {
                String line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    eof = true;
                }
            }
            digit.close();
        } catch (IOException e) {
            System.out.println("IO Error:" + e.getMessage());
        }
    }
}
