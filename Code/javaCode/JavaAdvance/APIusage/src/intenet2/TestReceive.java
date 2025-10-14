package intenet2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestReceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(10086);
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            if (str.equals("886")) {
                break;
            } else {
                System.out.println(str);
            }
        }
        ds.close();
    }
}
