package com.gupaoedu.rpc;

import com.gupaoedu.vip.IHelloService;

public class MyApp {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy
                (IHelloService.class, "localhost", 8080);
        System.out.println(iHelloService.sayHello("Mic"));
    }
}
