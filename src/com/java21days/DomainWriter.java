package com.java21days;

import nu.xom.*;
import java.io.*;

public class DomainWriter {
    public static void main(String[] args) throws IOException {
        try {
            // Creates a tree from an XML document
            // specified as a command-line argument
            Builder builder = new Builder();
            File xmlFile = new File("feed2.rss");
            Document doc = builder.build(xmlFile);

            // Creates a comment with the current time and date
            Comment timestamp = new Comment("File created "
                    + new java.util.Date());

            // Add the comment above everything else in the
            // document
            doc.insertChild(timestamp, 0);

            // Create a file output stream to a new file
            FileOutputStream f = new FileOutputStream("feed3.rss");

            // Using a serializer with indention set to 4 spaces,
            // write the XML document to the file
            Serializer output = new Serializer(f, "ISO-8859-1");
            output.setIndent(4);
            output.write(doc);
        } catch (ParsingException pe) {
            System.out.println("Parsing error: " + pe.getMessage());
            System.exit(-1);
        }
    }
}
