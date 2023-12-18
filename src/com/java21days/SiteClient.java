package com.java21days;

import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SiteClient {
    public static void main(String[] arguments) {
        SiteClient client = new SiteClient();
        try {
            HashMap<String, String> resp = client.getRandomSite();
            // Report the results
            if (!resp.isEmpty()) {
                System.out.println("URL: " + resp.get("url")
                        + "\nTitle: " + resp.get("title")
                        + "\nDescription: " + resp.get("description"));
            }
        } catch (IOException | XmlRpcException ioe) {
            System.out.println("Exception: " + ioe.getMessage());
        }
    }

    public HashMap getRandomSite()
            throws IOException, XmlRpcException {

        // Create the client
        XmlRpcClientConfigImpl config = new
                XmlRpcClientConfigImpl();
        URL server = new URL("http://localhost:4413/");
        config.setServerURL(server);
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        // Create the parameters for the request
        ArrayList params = new ArrayList();
        // Send the request and get the response
        HashMap result = (HashMap) client.execute(
                "curlie.getRandomSite", params);
        return result;
    }
}
