package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerUpload {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        // 获取客户端发来的文件
        InputStream inputStream = socket.getInputStream();

        File file = new File("/Users/StarLikeRain/Documents/爪哇创建的路径");
        if(!file.exists()){
            file.mkdirs();
        }

        // 本地文件输出流
        FileOutputStream fos = new FileOutputStream(file + "/服务器收到的图片.jpg");

        // 读取客户端发来的文件
        byte[] bytes = new byte[1024];
        int len = 0;

        // 来自于 serverSocket 的 inputStream
        while ( (len = inputStream.read(bytes)) != -1 ){
            fos.write(bytes, 0, len);
        }

        // 告知客户端我收到了

        // 关闭
        fos.close();
        socket.close();

    }
}
