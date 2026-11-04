import java.net.InetAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

        // Connect using HTTPS
        String url = "https://" + hostname;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        System.out.println("HTTPS Connection Successful");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("TLS Version: " + response.sslSession().get().getProtocol());
        System.out.println("Response Size: " + response.body().length + " bytes");
    }
}