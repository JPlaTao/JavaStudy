package Practice.P2_TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Clint {
    public static void main(String[] args) {
        try {
            System.out.println("连接到服务器...");
            Socket clint = new Socket("10.0.3.117",7777);
            System.out.println("连接成功");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clint.getInputStream())
            );
            PrintWriter out = new PrintWriter(clint.getOutputStream(),true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true){
                System.out.print("我：");
                message = userInput.readLine();
                out.println(message);

                String response = in.readLine();
                System.out.println("服务器：" + response);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
