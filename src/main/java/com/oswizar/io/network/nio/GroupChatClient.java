package com.oswizar.io.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {
    // define property
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6667;
    private final Selector selector;
    private final SocketChannel socketChannel;
    private final String clientName;

    // init constructor
    public GroupChatClient() throws IOException {
        selector = Selector.open();
        // connect to server
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        // get clientName
        clientName = socketChannel.getLocalAddress().toString();
        System.out.println(clientName + " successfully connected to the server: "+ HOST + ":" + PORT);
    }

    // send msg to server
    private void sendMessage(String msg) throws IOException {
        msg = clientName + " : " + msg;
        System.out.println("send: " + "{" + msg + "}");
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count = channel.read(buffer);
        if (count > 0) {
            String msg = new String(buffer.array()).trim();
            System.out.println("receive: " + "{" + msg + "}");
        }
    }

    public void run() {
        new Thread(() -> {
            try {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            while (true) {
                int readChannels = selector.select();
                if (readChannels > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isReadable()) {
                            handleRead(key);
                        }
                    }
                    // remove current selectionKey,prevent duplicate operating
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            selector.close();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // run client
        GroupChatClient chatClient = new GroupChatClient();
        chatClient.run();
    }

}
