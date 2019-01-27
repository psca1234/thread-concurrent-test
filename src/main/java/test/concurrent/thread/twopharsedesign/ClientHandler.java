package test.concurrent.thread.twopharsedesign;

import java.io.*;
import java.net.Socket;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/26 11:30
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/26 11:30
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ClientHandler implements Runnable {
    private volatile boolean runninged = true;

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintStream printStream = new PrintStream(outputStream)){
            while(runninged){
                String message = reader.readLine();
                if(null== message){
                    break;
                }
                System.out.println("Come from client>"+message);
                printStream.print("echo\t"+message+"\n");
                printStream.flush();
            }
        }catch (IOException e){
            this.runninged = false;
        }
    }

    public void stop(){
        if(!runninged){
            return;
        }
        this.runninged = false;
        try {
            this.socket.close();
        } catch (IOException e) {

        }

    }
}
