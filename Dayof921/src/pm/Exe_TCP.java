package pm;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {
    public static void main(String[] args) {
        int localPort = 12138;
        try (ServerSocket serverSocket = new ServerSocket(localPort);
             Socket acceptSocket = serverSocket.accept();
             InputStream inputStream = acceptSocket.getInputStream();
             OutputStream outputStream = acceptSocket.getOutputStream();
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(inputStream));
             Scanner scanner = new Scanner(System.in);
        ) {
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("服务端：客户端登录信息为：" + info);
            }
            String replay = "欢迎，登录成功";
            outputStream.write(replay.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client {

    public static void main(String[] args) {

        try (Socket client = new Socket("localhost", 12138);
             OutputStream outputStream = client.getOutputStream();
             InputStream inputStream = client.getInputStream();
        ) {
            String info = "用户名：admin,密码：12345";
            outputStream.write(info.getBytes());
            client.shutdownOutput();
            String replay = null;
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));
            while ((replay = bufferedReader.readLine()) != null) {
                System.out.println("客户端：服务器相应的内容为：" + replay);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
