package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {
        

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);
        ServerConnection serverConn = new ServerConnection(s);
        serverConn.start();

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        boolean controllo = true;
        while (controllo) {
            System.out.println("lista comandi:data, ora, client <nome>, server, echo <msg>, chiudi: ");
            String command = keyboard.readLine();
            out.println(command);
        }
        in.close();
        out.close();
        s.close();
    }
}
