package internet1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestSend {
    public static void main(String[] args) throws IOException {
        // Send message "Hello world" to localhost at port 10086
        byte[] buf = "Hello world".getBytes();
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        socket.send(new DatagramPacket(buf, buf.length, address, 10086));
        socket.close();

    }
}
