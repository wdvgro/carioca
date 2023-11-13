import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        String hostName = "localhost";
        int portNumber = 7789;

        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {

            // Read initial welcome messages from the server
            System.out.println(in.readLine());
            System.out.println(in.readLine());

            String userInput;

            while ((userInput = stdIn.readLine()) != null) {
                // Send user input to the server
                out.println(userInput);

                // Break the loop if the user enters "bye"
                if (userInput.equalsIgnoreCase("bye")) {
                    break;
                }

                // Receive and display the server's response
                System.out.println("Server: " + in.readLine());
                System.out.println("Server: " + in.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
