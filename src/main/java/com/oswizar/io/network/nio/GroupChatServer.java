package com.oswizar.io.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    // define port
    private static final int PORT = 6667;
    // define channel
    private final ServerSocketChannel listenChannel;
    // define selector
    private final Selector selector;

    // constructor init
    public GroupChatServer() throws IOException {
        listenChannel = ServerSocketChannel.open();
        selector = Selector.open();
        // bind port
        listenChannel.socket().bind(new InetSocketAddress(PORT));
        // set non-blocking mode
        listenChannel.configureBlocking(false);
        // channel register to selector
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server has started and is listening on port: " + PORT);
    }

    // server listen
    private void listen() {
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            handleAccept(key);
                        } else if (key.isReadable()) {
                            handleRead(key);
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("server listen exception");
            close();
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        // print notification
        System.out.println(socketChannel.getRemoteAddress() + " Online...");

    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        // create buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count = channel.read(buffer);
        if (count > 0) {
            // buffer data convert string
            String msg = new String(buffer.array()).trim();
            System.out.println("receive: " + "{" + msg + "}");
            // forward msg to other clients
            forwardMessage(msg, channel);
        } else {
            try {
                System.out.println(channel.getRemoteAddress() + " offline...");
                // cancel register
                key.cancel();
                // close channel
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // forward msg to other clients
    private void forwardMessage(String msg, SocketChannel self) throws IOException {
        System.out.println("forward: " + "{" + msg + "}");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            // excluding oneself
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                // make msg store to buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                // make buffer write to channel
                dest.write(buffer);
            }
        }
    }

    private void close() {
        try {
            selector.close();
            listenChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // run server
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();
    }
}
