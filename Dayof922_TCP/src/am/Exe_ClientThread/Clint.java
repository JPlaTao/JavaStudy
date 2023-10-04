package am.Exe_ClientThread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class Clint {
    public static void main(String[] args) {
//        InetAddress address = InetAddress.getByName("localhost");
//        int port = 12138;
        try (Socket client = new Socket(
                InetAddress.getByName("localhost"), 12138);
             InputStream inputStream = client.getInputStream();
             BufferedReader BReader = new BufferedReader(
                     new InputStreamReader(inputStream)
             );

             OutputStream outputStream = client.getOutputStream();
             BufferedWriter BWriter = new BufferedWriter(
                     new OutputStreamWriter(outputStream)
             );

             Scanner scanner = new Scanner(System.in);
        ) {
            String message;
            while (true) {
                System.out.print("我：");
                message = scanner.next();
                BWriter.write(message);
                BWriter.flush();

                message = BReader.readLine();
                System.out.println("服务器：" + message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
