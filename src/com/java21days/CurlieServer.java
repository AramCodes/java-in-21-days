package com.java21days;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;
import java.io.*;

public class CurlieServer {
    public static void main(String[] args) {
        try {
            startServer();
        } catch (IOException ioe) {
            System.out.println("Server error: " +
                    ioe.getMessage());
        } catch (XmlRpcException xre) {
            System.out.println("XML-RPC error: " +
                    xre.getMessage());
        }
    }

    public static void startServer() throws IOException,
            XmlRpcException {

        // Creates the server
        System.out.println("Starting Curlie server ...");
        WebServer server = new WebServer(4413);
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
        PropertyHandlerMapping phm = new PropertyHandlerMapping();

        // Registers the handler
        phm.addHandler("curlie", CurlieHandlerImpl.class);
        xmlRpcServer.setHandlerMapping(phm);

        // Starts the server
        server.start();
        System.out.println("Accepting requests ...");
    }
}
