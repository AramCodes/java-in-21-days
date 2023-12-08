package com.java21days;

import java.io.*;
public class BufferDemo {
//    buffers are essential while reading  extremely large files without the JVM memory could be overloaded
//    a buffered stream can be completed with any of the following constructors BufferedInputStream(InputStream) or
//    BufferedInputStream(InputStream, in) which specifies the buffer of size int
//    same is true for OutPutStreams BufferedOutputStream(OutputStream) or BufferedOutputStream(OutputStream, int)
//    which creates the specified output stream with the specified buffer size

    public static void main(String[] arguments) {
        int start = 0;
        int finish = 255;
        if (arguments.length > 1) {
            start = Integer.parseInt(arguments[0]);
            finish = Integer.parseInt(arguments[1]);
        } else if (arguments.length > 0) {
            start = Integer.parseInt(arguments[0]);
        }
        ArgStream as = new ArgStream(start, finish);
        System.out.println("\nWriting: ");
        boolean success = as.writeStream();
        System.out.println("\nReading: ");
        boolean readSuccess = as.readStream();
    }


}

class ArgStream {
    int start = 0;
    int finish = 255;

    ArgStream(int st, int fin) {
        start = st;
        finish = fin;
    }

    boolean writeStream() {
        try (FileOutputStream file = new
                FileOutputStream("numbers.dat");
             BufferedOutputStream buff = new
                     BufferedOutputStream(file)) {

            for (int out = start; out <= finish; out++) {
                buff.write(out);
                System.out.print(" " + out);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
    boolean readStream() {
        try (FileInputStream file = new
                FileInputStream("numbers.dat");
             BufferedInputStream buff = new
                     BufferedInputStream(file)) {

            int in;
            do {
                in = buff.read();
                if (in != -1) {
                    System.out.print(" " + in);
                }
            } while (in != -1);
            System.out.println();
            return true;
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}