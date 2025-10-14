package internet1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestReceive {
    public static void main(String[] args) throws IOException {

        // Receive message at port 10086
        byte[] receiveBuf = new byte[1024];
        DatagramSocket receiveSocket = new DatagramSocket(10086);
        DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);
        receiveSocket.receive(receivePacket);
        byte[] receivedData = receivePacket.getData();
        System.out.println(new String(receivedData, 0, receivePacket.getLength()));
        receiveSocket.close();
    }
}
