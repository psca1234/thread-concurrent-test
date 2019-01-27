package test.concurrent.thread.twopharsedesign;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 10:30
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 10:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AppServer extends Thread{
    private int port;
    private final static int DEFAULT_SEVER_PORT=12722;
    private volatile boolean started = true;
    private final ExecutorService executors = Executors.newFixedThreadPool(10);
    private List<ClientHandler> clientHandlers = new ArrayList<>();

    public AppServer(){
        this(DEFAULT_SEVER_PORT);
    }

    public AppServer(int port){
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket socket = new ServerSocket(port);
            while(started){
                Socket clientSocket = socket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                this.executors.submit(handler);
                this.clientHandlers.add(handler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            this.dispose();
        }
    }

    private void dispose() {
        this.clientHandlers.stream().forEach(ClientHandler::stop);
    }

    public void shutdown(){
        this.started = false;
    }
}
