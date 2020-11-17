package com.gupaoedu.rpc;

import com.gupaoedu.vip.IHelloService;
import com.gupaoedu.vip.User;

public class MyApp {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloService iHelloService = rpcProxyClient.clientProxy
                (IHelloService.class, "localhost", 8080);
        System.out.println(iHelloService.sayHello("Mic"));

        User user = new User();
        user.setName("test");
        user.setAge(18);
        System.out.println(iHelloService.saveUser(user));
    }
}
