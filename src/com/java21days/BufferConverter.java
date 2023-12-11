package com.java21days;

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;
public class BufferConverter {
    public static void main(String[] args) {
        try {
//            reads data into byte buffer
            String data = "friends.dat";
            FileInputStream inData = new FileInputStream(data);
            FileChannel inChannel = inData.getChannel();
            long inSize = inChannel.size();
            ByteBuffer source = ByteBuffer.allocate((int) inSize);
            inChannel.read(source, 0);
            source.position(0);
            System.out.println("Original byte data:");
            for (int i = 0; source.remaining() > 0; i++) {
                System.out.println(source.get() + " ");
            }
//            converts byte data into char data
            source.position(0);
            Charset ascii = StandardCharsets.US_ASCII;
            CharsetDecoder toAscii = ascii.newDecoder();
            CharBuffer destination = toAscii.decode(source);
            destination.position(0);
            System.out.println("\n\nNew character data:");
            for (int i =0; destination.remaining() > 0; i++) {
                System.out.println(destination.get());
            }
            System.out.println();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
