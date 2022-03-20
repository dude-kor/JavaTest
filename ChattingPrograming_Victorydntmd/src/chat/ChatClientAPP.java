package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.InetSocketAddress;
import java.net.Socket;

import java.nio.charset.StandardCharsets;

import java.util.Scanner;

public class ChatClientAPP {
    private static final String SERVER_IP = "172.30.1.32";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args){
        String name = null;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Type your chat name.");
            System.out.print(">>");
            name = scanner.nextLine();

            if(name.isEmpty() == false){
                break;
            }

            System.out.println("Chat name should be more than 1 letter");
        }
        scanner.close();

        Socket socket = new Socket();
        try{
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
            consoleLog("Chatting room entered");
            new ChatWindow(name, socket).show();

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);
            String request = "join : "+ name + "\r\n";
            pw.println(request);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void consoleLog(String log){
        System.out.println(log);
    }
}
