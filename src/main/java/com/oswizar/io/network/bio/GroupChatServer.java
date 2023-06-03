package com.oswizar.io.network.bio;

import java.io.*;
import java.net.*;
import java.util.*;

public class GroupChatServer {
    private static final int PORT = 8888;
    private List<ClientHandler> clientHandlers = new ArrayList<>();

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("群聊服务器已启动，监听端口：" + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("新客户端连接：" + socket.getRemoteSocketAddress());
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, ClientHandler excludeClient) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler != excludeClient) {
                clientHandler.sendMessage(message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String message) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("收到消息：" + message);
                    broadcastMessage(message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientHandlers.remove(this);
                System.out.println("客户端断开连接：" + socket.getRemoteSocketAddress());
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.start();
    }
}

