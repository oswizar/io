package com.oswizar.io.network.bio;

import java.io.*;
import java.net.*;
import java.util.*;

public class GroupChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 8888;

    public void start() {
        try {
            Socket socket = new Socket(HOST, PORT);
            System.out.println("成功连接到群聊服务器：" + HOST + ":" + PORT);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new Thread(new InputThread(writer)).start();

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("收到消息：" + message);
            }

            socket.close();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class InputThread implements Runnable {
        private BufferedWriter writer;

        public InputThread(BufferedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GroupChatClient chatClient = new GroupChatClient();
        chatClient.start();
    }
}

