package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是发送给服务器的数据".getBytes());

        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len =  is.read(bytes);

        System.out.println(new String(bytes, 0, len));


        socket.close();
    }
}
