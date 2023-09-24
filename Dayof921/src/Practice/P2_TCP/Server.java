package Practice.P2_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
           ServerSocket serverSocket = new ServerSocket(
                   12138,2,InetAddress.getByName("10.0.3.139"));
           System.out.println("服务器已启动，等待链接...");

           Socket clientSocket = serverSocket.accept();
           System.out.println("链接成功" + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter out =new PrintWriter(clientSocket.getOutputStream());

            String message;
            while ( (message = in.readLine()) != null ){
                System.out.println("客户端:" + message);
//                System.out.print("我：");
//                message = scanner.nextLine();
//                out.println(message);
                out.flush();
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
