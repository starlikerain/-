package com.company.clientIsBrowser;
/**
 * 当 client 为 browser 时
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sSocket = new ServerSocket(8080);
        while(true){
            Socket socket = sSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        handleServerLogic(socket);
                    }catch (IOException e){
                        System.out.println("这是来自于19行的Exception" + e);
                    }
                }
            }).start();


        }

//        sSocket.close();
    }

    public static void handleServerLogic (Socket socket) throws IOException {
        // 网络字节输入流对象
        InputStream socket_inputStream = socket.getInputStream();

        // 用buffer 缓冲区，接下浏览器的请求头信息
        BufferedReader bReader = new BufferedReader(new InputStreamReader(socket_inputStream));

        String str = bReader.readLine();
        // 分析出来自浏览器的 GET 请求路径 PATH
        String request_path = str.split(" ")[1].substring(1);
        System.out.println(request_path);

        // 创建本地的字节输入流，读取文件，准备发送给浏览器
        // notice: 这个路径是相对于当前项目的，不是当前这个 .java 文件的
        FileInputStream localFileReader = new FileInputStream(request_path);

        // 返回数据给浏览器
        OutputStream socket_outStream = socket.getOutputStream();
        socket_outStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        socket_outStream.write("Content-Type:text/html\r\n".getBytes());
        socket_outStream.write("\r\n".getBytes()); // 这个空的很关键

        int len;
        byte[] bytes = new byte[1024];

        while ((len = localFileReader.read(bytes)) != -1) {
            socket_outStream.write(bytes, 0, len);
        }

        // 这个 socket 是服务器端 accept 之后的真实的 Socket 实例
        socket.shutdownOutput();

        localFileReader.close();
        socket.close();
    }
}
