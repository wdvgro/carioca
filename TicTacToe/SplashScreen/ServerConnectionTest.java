import java.io.IOException;
import java.net.Socket;

public class ServerConnectionTest {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort =7789;

        try {

            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to the server successfully!");
            socket.close();
        } catch (IOException e) {
            System.err.println("Unable to connect to the server: " + e.getMessage());
        }
    }
}
