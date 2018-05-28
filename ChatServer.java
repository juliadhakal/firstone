/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketProgramming;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5558
 */
public class ChatServer {
    public static void main(String[] args)throws IOException 
    {
        
        
        
     int port = 7777;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server Started at Port " + port);
        Socket socket = serverSocket.accept();
        
        System.out.println("Client Connected " + socket.getInetAddress().getHostName());
        System.out.println("Start Chatting");
        final DataInputStream in = new DataInputStream(socket.getInputStream());
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        final Scanner sc = new Scanner(System.in);

        Thread readThread = new Thread() {

            public void run() {
                while (true) {
                    String msg;
                    try {
                        msg = in.readUTF();
                        System.out.println(msg);
                    } catch (IOException ex) {
                    }

                }
            }
        };
        Thread writeThread = new Thread() {

            public void run() {
                while (true) {
                    String msg = sc.nextLine();
                    try {
                        out.writeUTF(msg);
                    } catch (IOException ex) {
                    }
                }
            }

        };

        readThread.start();
        writeThread.start();
    }

}
