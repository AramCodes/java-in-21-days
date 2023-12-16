package com.java21days;

import nu.xom.*;

public class RssFilter {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RssFilter file term");
            System.exit(-1);
        }

//        saves the RSS location and search term
        String rssFile = args[0];
        String term = args[1];

        try {
//      Fills a tree with an RSS file's XML data, the file can be local or something
//      on th web accessible via a URL.
            Builder bob = new Builder();
            Document doc = bob.build(rssFile);

            // Gets the file's root element (<rss>)
            Element rss = doc.getRootElement();

            // Gets the element's version attribute
            Attribute rssVersion = rss.getAttribute("version");
            String version = rssVersion.getValue();

            // Adds the DTD for RSS 0.91 feeds, if needed
            if ( (version.equals("0.91")) &
                    (doc.getDocType() == null) ) {

                DocType rssDtd = new DocType("rss",
                        "https://my.netscape.com/publish/formats/rss-0.91. dtd");
                doc.insertChild(rssDtd, 0);
            }

            // Gets the first (and only) <channel> element
            Element channel = rss.getFirstChildElement("channel");

            // Gets its <title> element
            Element title = channel.getFirstChildElement("title");
            Text titleText = (Text) title.getChild(0);

            // Changes the title to reflect the search term
            titleText.setValue(titleText.getValue() +
                    ": Search for " + term + " articles");

            // Gets all the <item> elements and loops through them
            Elements items = channel.getChildElements("item");
            for (int i = 0; i < items.size(); i++) {
                // Get an <item> element
                Element item = items.get(i);

                // Looks for a <title> element inside it
                Element iTitle = item.getFirstChildElement("title");

                // If found, look for its contents
                if (iTitle != null) {
                    Text iTitleText = (Text) iTitle.getChild(0);

                    // If the search text is not found in the item,
                    // delete it from the tree
                    if (!iTitleText.toString().contains(term)) {
                        channel.removeChild(item);
                    }
                }
            }

            // Displays the results with a serializer
            Serializer output = new Serializer(System.out);
            output.setIndent(4);
            output.write(doc);
        } catch (Exception exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}
