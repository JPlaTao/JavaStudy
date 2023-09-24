package am;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exe_Internet {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("10.0.3.115");
            System.out.println(address);
            System.out.println(address.isReachable(10));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
