import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends JPanel {
    private JLabel connectionStatusLabel;
    private JTextField hostField;
    private JTextField portField;
    private JButton connectButton;

    public ConnectionPanel() {
        setLayout(new FlowLayout());

        connectionStatusLabel = new JLabel("Connecting to the server...");
        hostField = new JTextField("localhost", 15);
        portField = new JTextField("7789", 5);
        connectButton = new JButton("Connect");

        add(connectionStatusLabel);
        add(hostField);
        add(portField);
        add(connectButton);
    }

    public JLabel getConnectionStatusLabel() {
        return connectionStatusLabel;
    }

    public JTextField getHostField() {
        return hostField;
    }

    public JTextField getPortField() {
        return portField;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public void setConnectActionListener(Runnable listener) {
        connectButton.addActionListener(e -> listener.run());
    }
}
