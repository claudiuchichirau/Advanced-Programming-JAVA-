package org.example.compulsory.serverApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private Socket socket = null;
    private ServerSocket server = null;
    private final int port;
    private boolean isRunning;

    public GameServer(int port) {
        this.port = port;
        this.isRunning = true;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            this.server = server;
            System.out.println("Server started on port " + port);
            while (isRunning) {
                Socket clientSocket = server.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);

                clientThread.run();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public void stopServer() throws IOException {
        isRunning = false;
        System.out.println("Inchidere server (1)");
        server.close();
        System.exit(1);
    }

    public static void main(String[] args) {
        GameServer gameServer = new GameServer(5000);
        gameServer.start();
    }
}

