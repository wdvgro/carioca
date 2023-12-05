import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConnectionUtil {
    public static boolean attemptServerConnection(String serverHost, int serverPort) {
        try {
            Socket socket = new Socket(serverHost, serverPort);
            socket.close();
            return true;
        } catch (ConnectException e) {
            System.err.println("Cannot connect to the server: Connection refused");
            return false;
        } catch (IOException e) {
            System.err.println("Cannot connect to the server: " + e.getMessage());
            return false;
        }
    }
}
