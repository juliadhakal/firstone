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
public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.123.19",7777);
        System.out.println("Connected to server"+socket.getInetAddress().getHostName());
        System.out.println("Start chatting");
        final Scanner sc= new Scanner(System.in);
        final DataInputStream in = new DataInputStream(socket.getInputStream());
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
          Thread writeThread=new Thread(){
          
            public void run()
            {
                while(true)
                {
                    String msg=sc.nextLine();
                    try {
                      //  System.out.print("Sudhir: ");
                        out.writeUTF(msg);
                    } catch (IOException ex) {
                     }
                }
            }
            
        };
        
        
          Thread readThread=new Thread(){
          
            public void run()
            {
                while(true)
                {
                    String msg;
                    try {
                        System.out.print("Kabina: ");
                        msg = in.readUTF();
                        System.out.println(msg);
                    } catch (IOException ex) {
                     }
                    
                }
            }
        };
        
          
          readThread.start();
          writeThread.start();
    }
    
}
