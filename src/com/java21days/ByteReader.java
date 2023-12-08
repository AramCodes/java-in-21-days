package com.java21days;

import java.io.*;
public class ByteReader {
//    filtering a stream 1. create a stream associated with a data source or data destination
//    2. Associate a filter with that stream
//    3.Read or write data to that filter instead of the original stream (read() or write() or clos() methods)\

    public static void main(String[] args) {
        try (
                FileInputStream file = new
                        FileInputStream("save.gif")
        ) {

            boolean eof = false;
            int count = 0;
            while (!eof) {
                int input = file.read();
                System.out.print(input + " ");
                if (input == -1)
                    eof = true;
                else
                    count++;
            }
            System.out.println("\nBytes read: " + count);
        } catch (IOException exc) {
            System.out.println("Error -- " + exc.toString());
        }
    }
}
