package com.java21days;

import java.sql.*;
public class CustomerReporter {
//    if the server is identified by its IP address, use the InetAddress class in java.net to identify th host. call static method
//    InetAddress.getByName(String) with the host IP address as the argument. method returns InetAddress object representing the
//    address, which you can use in calling InetSocketAddress(InetAddress, int). The second arg is the port number

//    Nonblocking connections require a socket channel, another of the nio classes. call the static .open() of the SocketChannel
//    class to create the channel.  A socket channel can be configured for blocking or nonblocking communication. To set simply use
//    the channel's .configureBlocking(boolean value). After the channel is configured call its .connect(InetSocketAddress) to connect
//    to the socket. while blocking the .connect method attempts to connect and return true when completed. While nonblocking the method
//    returns immediately with the value of false and to monitor the channel you must use a channel-listening object called a selector.
//    A selector object keeps track of things that happen to the socket channel. to create a Selector object call the .open() like
//    Selector monitor = Selector.open(). When you use a selector object you must indicate the events you want to monitor. You do so
//    by calling a channel's .register(Selector, int, object) 1st argument is the selector that monitors the channel, 2nd argument
//    is and int value that represents the events being monitored, and 3rd argument an object that can be delivered along with the key,
//    or null otherwise.  Instead of using the second argument it is more efficient to use one or more class variables from the
//    selection keys class: SelectionKey.OP_CONNECT, SelectionKey.OP_WRITE, SelectionKey.OP_READ . The following statements
//    create a selector to monitor a socket channel called wire to read data: Selector spy = selector.open();
//    channel.register(spy, SelectionKey.OP_READ, null) to monitor more than one kind of key: Selector spy = selector.open();
//    channel.register(spy, SelectionKey.OP_READ + SelectionKey.OP_WRITE, null) after the channel and selector have been
//    set up you can wait for events by calling the selector's .select() or .select(long). select waits until something happens
//    and the long argument makes it wait until something happens or the specified number of milliseconds has passed

//ResultSet set = looksee.executeQuery(
// "SELECT NAME, CITY" FROM APP.CUSTOMER "
//    + " WHERE (STATE = "FL") ORDER BY CITY"
// );
// getDate(String)
// getDouble(String)
// getFloat(String)
// getInt(String)
// getLong(String)
// getString(String)

    public static void main(String[] arguments) {
        String data = "jdbc:derby://localhost:1527/sample";
        try (
                Connection conn = DriverManager.getConnection(
                        data, "app", "app");
                Statement st = conn.createStatement()) {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            ResultSet rec = st.executeQuery(
                    "select CUSTOMER_ID, NAME, CITY, STATE " +
                            "from APP.CUSTOMER " +
                            "order by CUSTOMER_ID");
            while (rec.next()) {
                System.out.println("CUSTOMER_ID: "
                        + rec.getString(1));
                System.out.println("NAME: " + rec.getString(2));
                System.out.println("CITY: " + rec.getString(3));
                System.out.println("STATE: " + rec.getString(4));
                System.out.println();
            }
            rec.close();
        } catch (SQLException s) {
            System.out.println("SQL Error: " + s + " "
                    + s.getErrorCode() + " " + s.getSQLState());
        } catch (Exception e) {
            System.out.println("Error: " + e
                    + e.getMessage());
        }
    }
}
