/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 5558
 */
public class Client {
    public static void main(String[] args) throws IOException {
        
        Socket socket=new Socket("localhost",9000);
        System.out.println("Connected to server "+socket.getInetAddress().getHostAddress());
        
        DataInputStream in=new DataInputStream(socket.getInputStream());
        DataOutputStream out=new DataOutputStream(socket.getOutputStream());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length");
        double length=sc.nextDouble();
        System.out.println("Enter breadth");
        double breadth=sc.nextDouble();
        
        out.writeDouble(length);
        out.writeDouble(breadth);
        
        System.out.println("The area of rectangle is "+in.readDouble());
        
    }
}
