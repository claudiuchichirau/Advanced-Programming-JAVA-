package org.example.compulsory.clientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public GameClient(String host, int port) throws IOException {
        socket = new Socket(host, port);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() throws IOException {
        String response = in.readLine();
        System.out.println(response);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = console.readLine();
            out.println(command);
            String response1 = in.readLine();   // response = "Server received the request [...]
            System.out.println(response1);

            String response2 = in.readLine();     // the response
            System.out.println(response2);

            if (command.equals("exit") || response2.equals("Client stopped.")) {
                System.out.println("");
                break;
            }
        }
        in.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            ;GameClient client = new GameClient("127.0.0.1", 5000);
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
