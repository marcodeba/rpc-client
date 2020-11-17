package com.gupaoedu.rpc;

import com.gupaoedu.vip.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request) {
        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            socket = new Socket(host, port); //建立连接
            // 客户端发送数据到服务端
            outputStream = new ObjectOutputStream(socket.getOutputStream());//网络socket
            outputStream.writeObject(request); //序列化()
            outputStream.flush();

            // 服务端方法返回数据
            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                    inputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                    outputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                    socket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
