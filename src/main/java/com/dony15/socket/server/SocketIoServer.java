package com.dony15.socket.server;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.handler.SuccessAuthorizationListener;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.corundumstudio.socketio.protocol.Packet;
import com.dony15.socket.dto.Message;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author DonY15
 * @description SocketIO
 * @create 2018\10\20 0020
 */
@Component
public class SocketIoServer implements ApplicationRunner,Ordered {
    public void socketIoInit() throws InterruptedException {
        AuthorizationListener authorizationListener = new SuccessAuthorizationListener();
        Configuration config = new Configuration();
        config.setPort(8000);
        config.setHostname("localhost");
        config.setAuthorizationListener(authorizationListener);


        SocketIOServer server = new SocketIOServer(config);
        System.out.println("启动成功");

        //连接监听
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient client) {
                System.out.println("连接成功:"+client.getRemoteAddress());
            }
        });

        //事件监听
        server.addEventListener("message",Message.class, new DataListener<Message>() {

            @Override
            public void onData(SocketIOClient client, Message data, AckRequest ackSender) throws Exception {
                client.sendEvent("message",data);
            }
        });

        //关闭监听
        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient client) {
                System.out.println("关闭一个连接");
            }
        });
        server.start();
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }






    @Override
    public void run(ApplicationArguments args) throws Exception {
        socketIoInit();
    }
    @Override
    public int getOrder() {
        return 1;   //指定启动顺序
    }
}
