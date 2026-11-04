import java.net.InetAddress;

public class NetworkInspector {
    public static void main(String[] args) throws Exception {

        String hostname = args[0];

        // Get all IP addresses for the hostname
        InetAddress[] ips = InetAddress.getAllByName(hostname);

        System.out.println("Hostname: " + hostname);
        System.out.println("Resolved Addresses:");

        for (int i = 0; i < ips.length; i++) {
            System.out.println(ips[i].getHostAddress());
        }
    }
}