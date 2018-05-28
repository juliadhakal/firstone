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
/**
 *
 * @author 5558
 */
public class Server {
    public static void main(String[] args) throws IOException {

        int port = 9000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server Started at port " + port);
        Socket socket = serverSocket.accept();
        System.out.println("Client Connected " + socket.getInetAddress().getHostName());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        
        double length=in.readDouble();
        double breadth=in.readDouble();
        
        out.writeDouble(length*breadth);

    }


}
