package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes); // 读取客户端发来的数据

        System.out.println(new String(bytes, 0, len));

        OutputStream os = socket.getOutputStream();
        os.write("我是服务器，我收到了，谢谢哈".getBytes());

        socket.close();
        serverSocket.close();
    }
}
