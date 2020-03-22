package com.company.uploadDIYFileName;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerUpload {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);


        while (true) {
            Socket socket = serverSocket.accept();
            // 多线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        uploadLogic(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 关你妹，不让关了
//        socket.close();
    }

    public static void uploadLogic(Socket socket) throws IOException {


        // 获取客户端发来的文件
        InputStream inputStream = socket.getInputStream();

        File file = new File("/Users/StarLikeRain/Documents/爪哇创建的路径");
        if (!file.exists()) {
            file.mkdirs();
        }

        // 按照时间轴，给出文件名
        String timeLineFileName =
                "/" + System.currentTimeMillis() + new Random().nextInt(99999) + ".jpg";

        // 本地文件输出流
        FileOutputStream fos = new FileOutputStream(file + timeLineFileName);

        // 读取客户端发来的文件
        byte[] bytes = new byte[1024];
        int len = 0;

        // 来自于 serverSocket 的 inputStream
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        // 告知客户端我收到了
        socket.getOutputStream().write("我是服务器，我收到你的文件了".getBytes());
        socket.shutdownOutput();

        // 关闭 fos 实例
        fos.close();

    }
}
