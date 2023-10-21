package am.Exe_ClientThread;

import am.Exe_ClientThread.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Server{
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(12138);) {
            System.out.println("服务器已启动");

            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                    5,10,1, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10)
            );
            while (true){
                System.out.println("等待连接中......");
                Socket client = server.accept();
                System.out.println("连接成功");
//                ClientThread clientT1 = new ClientThread(client);
                threadPool.execute(new ClientThread(client));
                System.out.println("创建线程成功，客户端：" + client.getInetAddress().getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}