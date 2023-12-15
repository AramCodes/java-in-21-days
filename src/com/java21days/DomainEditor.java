package com.java21days;

import nu.xom.*;
import java.io.*;


public class DomainEditor {

    public static void main(String[] args) throws IOException {
        try {
//            creates a tree from the XML doc
            Builder builder = new Builder();
            File xmlFile = new File("feed.rss");
            Document doc = builder.build(xmlFile);

//            gets the root element
            Element root = doc.getRootElement();

//            gets the <channel> element
            Element channel = root.getFirstChildElement("channel");


//             gets the <link> elements
            Elements children = channel.getChildElements();
            for (int i = 0; i < children.size(); i++) {

//             gets a <link> element
                Element link = children.get(i);

//                 gets the text
                Text linkText = (Text) link.getChild(0);

//                 updates any link matching a URL
                if (linkText.getValue().equals(
                        "https://workbench.cadenhead.org/")) {

//                     update the link's text
                    link.removeChild(0);
                    link.appendChild("https://workbench.cadenhead.org/");
                }
            }

            // creates new elements and attributes to add
            Element item = new Element("item");
            Element itemTitle = new Element("title");

            // adds them(the new elements) to the <channel> element
            itemTitle.appendChild(
                    "Free the Bound Periodicals"
            );
            item.appendChild(itemTitle);
            channel.appendChild(item);

            // Save the XML document
            try (
                    FileWriter fw = new FileWriter("feed2.rss");
                    BufferedWriter out = new BufferedWriter(fw);
            ) {
                out.write(doc.toXML());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            System.out.println(doc.toXML());

        } catch (ParsingException pe) {
            System.out.println("Parse error: " + pe.getMessage());
        }
    }

}
