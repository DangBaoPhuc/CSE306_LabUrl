package eiu.cit.netprog;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

//import org.apache.commons.codec.digest.DigestUtils;

public class NetworkInterfacecLoopBack {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getByName("192.168.198.92");

            NetworkInterface ni = NetworkInterface.getByInetAddress(local);

            if (ni == null) {

                System.err.println("That's weird. No local loopback address.");

            } else {

                System.out.println(ni);

            }
            // Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            // while (interfaces.hasMoreElements()) {

            //     NetworkInterface ni2 = interfaces.nextElement();

            //     System.out.println(ni2);

            // }

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }
}