package am.Exe_ClientThread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {
    Socket client;

    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (InputStream inputStream = client.getInputStream();
             OutputStream outputStream = client.getOutputStream();
             BufferedReader BReader = new BufferedReader(
                     new InputStreamReader(inputStream)
             );
             BufferedWriter BWriter = new BufferedWriter(
                     new OutputStreamWriter(outputStream)
             );
             Scanner scanner = new Scanner(System.in);
        ) {
            String message;
            while (true) {
                System.out.println("读取输入");
                message = BReader.readLine();
                System.out.println(client.getInetAddress().getHostAddress() +
                        ": " + message
                );
                System.out.println("输入信息打印完毕，开始等待接收输出信息");
                message = scanner.nextLine();
                BWriter.write(message);
                BWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
