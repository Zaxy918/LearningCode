package intenet2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TestSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            ds.send(new DatagramPacket(str.getBytes(), str.getBytes().length, address, 10086));
            if (str.equals("886")) {
                break;
            }
        }
        sc.close();
        ds.close();
    }
}
