package com.company.tcpserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        readAsByte();
    }

    public static void readAsByte() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(80);


        while (true) {
            Socket socket = ourFirstServerSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataStream = new DataInputStream(inputStream);
            int msgLen = dataStream.readInt();
            byte[] arr = new byte[msgLen];
            dataStream.readFully(arr);
            System.out.println("message length" + arr.length);
            System.out.println(new String(arr));
            Files.write(Paths.get("Ali.jpg"), arr);
        }
    }

    public static void readAsString() throws Exception {
        ServerSocket ourFirstServerSocet = new ServerSocket(6789);
        while (true) {
            Socket socket = ourFirstServerSocet.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String messageFromClirnt = bufferedReader.readLine();
            System.out.println("musteri deyir ki :" + messageFromClirnt);
        }
    }
}
