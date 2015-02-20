package com.gboban70.jserver;

public class Main{
    public static void main(String[] args) {
        /*
        use: jserver [port] [address]
         */
        int port = 0;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
        }else{
            port = 8090;
        }

        try{
            Thread serverThread = new JServer(port);
            serverThread.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
