package com.gboban70.jserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by goran on 2/20/15.
 */
public class JServer extends Thread{
    private ServerSocket serverSocket = null;
    private int socketTimeout = 10000;

    public JServer(int port){
        try{
            this.serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(socketTimeout);
        }catch(IOException ioex){
            ioex.printStackTrace();
        }
    }
    public void run(){
        while(true){
            try{
                System.out.println("Accepting connections on port: " + serverSocket.getLocalPort() + "...");
                Socket socket = serverSocket.accept();

                System.out.println("Request from " + socket.getRemoteSocketAddress());

                // get request data
                /*
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("DATA:");
                System.out.println(in.readUTF());
                System.out.println("-------------------------------------------------");
                */
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeBytes("Hello!");
                //in.close();
                out.close();
                socket.close();

            }catch(SocketTimeoutException e){
                System.out.println("Socket operation timed out");
            }catch(IOException e){
                e.printStackTrace();
                break;
            }
        }
    }
}