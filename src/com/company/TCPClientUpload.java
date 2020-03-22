package com.company;

import java.io.*;
import java.net.Socket;

public class TCPClientUpload {
    public static void main(String[] args) throws IOException {
        // 本地硬盘文件读取流
        FileInputStream fis = new FileInputStream("/Users/StarLikeRain/Documents/_JavaCodes/1/复制来的图.png");

        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            // 发送给服务器
            outStream.write(bytes, 0, len);
        }

        socket.shutdownOutput();

        // 获取服务器的返回
        InputStream inStream = socket.getInputStream();
        while ((len = inStream.read(bytes)) != -1) {
            // 看看服务器返回了什么东西
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
        socket.close();
    }
}
