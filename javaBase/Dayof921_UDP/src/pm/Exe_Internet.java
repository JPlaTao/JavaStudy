package pm;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

class Service {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             DatagramSocket socket = new DatagramSocket(12138)
        ) {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buff = new byte[64 * 1024];
            System.out.println("服务端启动");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(
                        buff, 0, buff.length, address, 12138);
                socket.receive(receivePacket);
                String msg = new String(buff, 0, receivePacket.getLength());
                System.out.println(receivePacket.getAddress() + "：" + msg);
                System.out.print("我： ");
                String sendMsg = scanner.nextLine();
                DatagramPacket sendPacket = new DatagramPacket(sendMsg.getBytes(), 0, sendMsg.getBytes().length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Clint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (DatagramSocket socket = new DatagramSocket(12148)) {
                InetAddress address = InetAddress.getByName("10.0.3.217");
                int port = 12138;
//            byte[] sendBuff = new byte[64*1024];
                String sendMsg = scanner.nextLine();
//                String str = "suka blyat!";
                byte[] sendBuf = sendMsg.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuf, 0, sendBuf.length, address, port);
                socket.send(sendPacket);
                System.out.println("发送成功");

                byte[] buf = new byte[64 * 1024];
                DatagramPacket receivePacket = new DatagramPacket(
                        buf,0, buf.length,address,port);
                socket.receive(receivePacket);

                String receivedMsg = new String(
                        buf,0,receivePacket.getLength(),"UTF-8");

                System.out.println("服务器：" + receivedMsg);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClintSendFile{

}
